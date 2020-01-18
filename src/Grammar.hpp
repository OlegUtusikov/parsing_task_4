#pragma once

#include <unordered_map>
#include <unordered_set>
#include "Terminal.hpp"
#include "NonTerminal.hpp"

class Grammar
{
public:
	
	Grammar() = default;
	Grammar(std::string const& start);

	Grammar& addTerminal(Terminal const& term, bool droped = false);
	Grammar& addNonTerminal(NonTerminal&& nonTerm);
	Grammar& setHeader(std::string const& header);
	Grammar& setStart(std::string const& start);

	void generate();

private:

	void processFirstSet();
	void processFollowSet();

	void generateParser();
	void generateLexer();
	std::unordered_set<std::string> getFirstSet(Rule const& rule, size_t index);
	std::unordered_set<std::string> getFollowSet(Rule const& rule, size_t index);
	std::size_t find(std::string const& firstName, NonTerminalPtr const& nTerm);
	void print(Rule const& rule, std::ofstream& cppFile);
private:

	std::string start;
	std::string header;

	std::unordered_map<std::string, NonTerminalPtr> nonTerms;
	std::unordered_map<std::string, TerminalPtr> terms;
	std::unordered_set<std::string> dropedTerminals;

	std::unordered_map<std::string, std::unordered_set<std::string>> first;
	std::unordered_map<std::string, std::unordered_set<std::string>> follow;
};
