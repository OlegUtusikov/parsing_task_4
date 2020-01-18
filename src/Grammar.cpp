#include <fstream>
#include <sstream>
#include <iostream>

#include "Grammar.hpp"
#include "Tools.hpp"


Grammar::Grammar(std::string const& start) : start(start)
{}

Grammar& Grammar::addTerminal(Terminal const& term, bool droped)
{
	terms.insert({ term.name, std::make_shared<Terminal>(term) });
	if (droped)
	{
		dropedTerminals.insert(term.name);
	}
	return *this;
}

Grammar& Grammar::addNonTerminal(NonTerminal&& nonTerm)
{
	auto ptr = std::make_shared<NonTerminal>( std::move(nonTerm) );
	nonTerms.insert({ ptr.get()->name, ptr });
	return *this;
}

Grammar& Grammar::setHeader(std::string const& header)
{
	this->header = header;
	return *this;
}

Grammar& Grammar::setStart(std::string const& start)
{
	this->start = start;
	return *this;
}

void Grammar::generate()
{
	processFirstSet();
	processFollowSet();
	generateLexer();
	generateParser();
	std::cout << "Generated!" << std::endl;
}

void Grammar::processFirstSet()
{
	bool changed = true;
	while(changed)
	{
		changed = false;
		for (auto const& [key, nTerm] : nonTerms)
		{
			auto const& left = nTerm->name;
			for (auto const& rule : nTerm->rules)
			{
				auto firstSet = getFirstSet(rule, 0);
				auto prevSize = first[left].size();
				first[left].insert(firstSet.begin(), firstSet.end());
				changed |= prevSize != first[left].size();
			}
		}
	}
}

void Grammar::processFollowSet()
{
	follow[start].insert("END");

	bool changed = true;
	while (changed)
	{
		changed = false;
		for (auto const& [key, nTerm] : nonTerms)
		{
			auto const& left = nTerm->name;

			for (auto const& rule : nTerm->rules)
			{
				for (std::size_t i = 0; i < rule.size(); ++i)
				{
					if (rule[i].name == "CODE" || rule[i].name == "EPS" || std::isupper(rule[i].name[0]))
					{
						continue;
					}

					std::size_t prevSize = follow[rule[i].name].size();
					auto curFollowSet = getFollowSet(rule, i + 1);

					if (curFollowSet.count("EPS") > 0 || curFollowSet.count("END") > 0)
					{
						curFollowSet.erase("EPS");
						follow[rule[i].name].insert(follow[left].begin(), follow[left].end());
					}

					follow[rule[i].name].insert(curFollowSet.begin(), curFollowSet.end());
					changed |= (prevSize != follow[rule[i].name].size());
				}
			}
		}
	}
}

std::unordered_set<std::string> Grammar::getFirstSet(Rule const& rule, size_t index)
{
	if (index == rule.size())
	{
		return { "EPS" };
	}
	else
	{
		auto const& name = rule[index].name;
		if (name == "EPS")
		{
			return { "EPS" };
		}
		else if (name == "CODE")
		{
			return getFirstSet(rule, index + 1);
		}
		else if (isupper(name[0]))
		{
			return { name };
		}
		else
		{
			auto curFirstSet = first[name];
			if (curFirstSet.count("EPS"))
			{
				curFirstSet.erase("EPS");
				auto newFirstSet = getFirstSet(rule, index + 1);
				curFirstSet.insert(newFirstSet.begin(), newFirstSet.end());
			}
			return curFirstSet;
		}
	}
}

std::unordered_set<std::string> Grammar::getFollowSet(Rule const& rule, size_t index)
{
	if (index == rule.size())
	{
		return { "END" };
	}
	else
	{
		auto const& name = rule[index].name;
		if (name == "EPS")
		{
			return { "EPS" };
		}
		else if (name == "CODE")
		{
			return getFollowSet(rule, index + 1);
		}
		else if (isupper(name[0]))
		{
			return { name };
		}
		else
		{
			auto curFirstSet = first[name];
			if (curFirstSet.count("EPS"))
			{
				curFirstSet.erase("EPS");
				auto newFollowSet = getFollowSet(rule, index + 1);
				curFirstSet.insert(newFollowSet.begin(), newFollowSet.end());
			}
			return curFirstSet;
		}
	}
}

void Grammar::generateLexer()
{
	std::ofstream outH;
	outH.open("lexer.hpp");
	outH << "#pragma once" << std::endl;
	outH << "#include <regex>\n#include <string>\n#include <unordered_set>\n#include <map>\n#include <stdexcept>" << std::endl;
	outH << std::endl;
	outH << "enum Token\n{" << std::endl;
	outH << "\t";
	bool firstTerminal = true;
	for (auto const& [key, term] : terms)
	{
		outH << (!firstTerminal ? ", " : "") << term->name;
		firstTerminal = false;
	}
	outH << ", END" << std::endl;
	outH << "};\n" << std::endl;
	outH << "struct lexer\n{" << std::endl;
	outH << "\tlexer();" << std::endl;
	outH << "\tvoid setInput(std::string const& input)\n\t{\n\t\tthis->input = input;\n\t\tthis->curPos = 0;\n\t\tnextToken();\n\t}\n"
	     << "\tvoid nextToken();\n"
	     << "\tToken getCurToken() const { return curToken; }\n"
	     << "\tstd::string getCurTokenStr() const { return curTokenStr; }\n"
	     << "\tstd::size_t getCurPos() const { return curPos; }\n" << std::endl
	     << "\tstd::string input { \"\" };\n"
	     << "\tToken curToken { Token::END };\n"
	     << "\tstd::string curTokenStr { \"\" };\n"
	     << "\tstd::size_t curPos { 0 };\n"
	     << "\tstd::map<Token, std::regex> tokenReg;\n"
	     << "\tstd::unordered_set<Token> drops { ";
	firstTerminal = true;
	for (auto const& name : dropedTerminals)
	{
		outH << (!firstTerminal ? ", " : "") << name;
		firstTerminal = false;
	}
	outH << " };\n"
	     << "\tstatic const int tokenCount = " << terms.size() << ";\n";

	outH << "};" << std::endl;
	outH.close();
	
	std::ofstream outCPP;
	outCPP.open("lexer.cpp");
	outCPP << "#include \"lexer.hpp\"\n" << std::endl;

	outCPP << "lexer::lexer() : curPos(0)\n{" << std::endl;
	for (auto const& [key, term] : terms)
	{
		outCPP << "\ttokenReg[" << "Token::" << term->name << "] = std::regex(\"^" << term->regexp << "\");\n";
	}
	outCPP << "}\n" << std::endl;

	outCPP << "void lexer::nextToken()\n{\n";
	outCPP << "\tif (curPos + 1 == input.size() || input[curPos] == '~')\n";
	outCPP << "\t{\n\t\tcurToken = Token::END;\n\t\tcurTokenStr = \"~\";\n\t\treturn;\n\t}\n";
	outCPP << "\tstd::smatch matcher;\n"
	       << "\tfor (auto const& [token, reg] : tokenReg)\n\t{\n"
	       << "\t\tif (std::regex_search(input.cbegin() + curPos, input.cend(), matcher, reg))\n\t\t{\n"
	       << "\t\t\tcurToken = token; curTokenStr = matcher.str(); curPos += curTokenStr.size();\n"
	       << "\t\t\tif (drops.count(curToken) > 0) nextToken();\n"
	       << "\t\t\treturn;\n"
	       << "\t\t}\n"
	       << "\t}\n" << "\tthrow std::runtime_error(\"Unkown symbol\");\n";
	outCPP << "}" << std::endl;
	outCPP.close();
}

void Grammar::generateParser()
{
	std::ofstream outH;
	outH.open("parser.hpp");
	outH << "#pragma once" << std::endl;
	outH << "#include <stdexcept>" << std::endl;
	outH << "#include \"lexer.hpp\"\n" << "#include \"Tools.hpp\"\n" << header << std::endl;
	outH << "struct parser\n{" << std::endl;
	outH << "\tlexer lex;\n" << std::endl;
	outH << "\tvoid setInput(std::string const& input) { lex.setInput(input + \"~\"); }" << std::endl;
	for (auto const& [key, nTerm] : nonTerms)
	{
		outH << "\tResult<" << nTerm->returns << "> " << "f_" << nTerm->name << "(" << nTerm->arguments << ");" << std::endl;
	}
	outH << "};\n" << std::endl;
	outH.close();

	std::ofstream outCPP;
	outCPP.open("parser.cpp");
	outCPP << "#include \"parser.hpp\"\n" << std::endl;
	for (auto const& [key, nTerm] : nonTerms)
	{
		outCPP << "Result<" << nTerm->returns << "> parser::" << "f_" << nTerm->name << "(" << nTerm->arguments << ")\n{" << std::endl;
		outCPP << "\tResult<" << nTerm->returns << "> result;" << std::endl;
		outCPP << "\tresult.node = NodePtr(new Node(\"" << key << "\"));" << std::endl;
		outCPP << "\t" << nTerm->returns << " " << "out;" << std::endl;
		outCPP << "\tToken curToken = lex.getCurToken();" << std::endl;
		outCPP << "\tswitch(curToken)\n\t{" << std::endl;
		bool isEps = false;
		for (auto const& term : first[key])
		{
			if (term == "EPS")
			{
				isEps = true;
				continue;
			}
			outCPP << "\t\tcase " + term + ":\n\t\t{\n";

			std::size_t rule = find(term, nTerm);
			print(nTerm->rules[rule], outCPP);
			outCPP << "\t\t\tbreak;\n";
			outCPP << "\t\t}\n";
		}
		if (isEps)
		{
			for (auto const& term : follow[key])
			{
				if (term == "END")
				{
					outCPP << "\t\tcase END:" << std::endl;
				}
				else
				{
					outCPP << "\t\tcase " << term << ":" << std::endl;
				}
			}
			outCPP << "\t\t{\n";
			std::size_t rule = find("EPS", nTerm);
			print(nTerm->rules[rule], outCPP);
			outCPP << "\t\t\tbreak;\n";
			outCPP << "\t\t}\n";
		}
		outCPP << "\t\tdefault:\n\t\t\tthrow std::runtime_error(\"Haven't rule for " << key << "\");" << std::endl;
		outCPP << "\t}" << std::endl;
		outCPP << "\tresult.out = out;" << std::endl;
		outCPP << "\treturn result;" << std::endl;
		outCPP << "}\n" << std::endl;
	}
	outCPP.close();
}

std::size_t Grammar::find(std::string const& firstName, NonTerminalPtr const& nTerm)
{
	std::size_t index = -1;
	auto const& rules = nTerm->rules;
	auto rulesSize = rules.size();
	for (std::size_t i = 0; i < rulesSize; ++i)
	{
		auto const& curRight = rules[i][0];
		if (std::isupper(curRight.name[0]))
		{
			if (firstName == curRight.name)
			{
				if (index == -1)
				{
					index = i;
				}
				else
				{
					throw std::runtime_error("Bad grammar, 1");
				}
			}
		}
		else
		{
			if (first[curRight.name].count(firstName) > 0)
			{
				if (index == -1)
				{
					index = i;
				}
				else
				{
					throw std::runtime_error("Bad grammar, 2");
				}
			}
		}
	}
	return index;
}

void Grammar::print(Rule const& rule, std::ofstream& file)
{
	for (auto  const& [name, code] : rule)
	{
		if (name == "EPS")
		{
			file << "\t\t\tresult.node->addChild(NodePtr(new Node(\"EPS\")));\n";
		}
		else if (name == "CODE")
		{
			file << "\t\t\t" << code << "\n";
		}
		else if (std::isupper(name[0]))
		{
			file << "\t\t\tif (lex.getCurToken() != Token::" << name << ") throw std::runtime_error";
			file << "(\"Inccorect token: \" + std::to_string(lex.getCurToken()) + \" Str: \" + lex.getCurTokenStr());\n";
			file << "\t\t\tResult<std::string> " << name << " { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };\n";
			file << "\t\t\tresult.node->addChild(" << name << ".node);\n";
			file << "\t\t\tlex.nextToken();\n";
		}
		else
		{
			file << "\t\t\tauto " << name << " = " << "f_" << name << "(" << code << ");\n";
			file << "\t\t\tresult.node->addChild(" << name << ".node);\n";
		}
	}
}
