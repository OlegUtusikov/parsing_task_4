#include "lexer.hpp"

lexer::lexer() : curPos(0)
{
	tokenReg[Token::XOR] = std::regex("^\\bxor\\b");
	tokenReg[Token::WS] = std::regex("^[ \t\r\n]");
	tokenReg[Token::OR] = std::regex("^\\bor\\b");
	tokenReg[Token::VAR] = std::regex("^[a-z]");
	tokenReg[Token::NOT] = std::regex("^\\bnot\\b");
	tokenReg[Token::RBR] = std::regex("^[)]");
	tokenReg[Token::LBR] = std::regex("^[(]");
	tokenReg[Token::AND] = std::regex("^\\band\\b");
}

void lexer::nextToken()
{
	if (curPos + 1 == input.size() || input[curPos] == '~')
	{
		curToken = Token::END;
		curTokenStr = "~";
		return;
	}
	std::smatch matcher;
	for (auto const& [token, reg] : tokenReg)
	{
		if (std::regex_search(input.cbegin() + curPos, input.cend(), matcher, reg))
		{
			curToken = token; curTokenStr = matcher.str(); curPos += curTokenStr.size();
			if (drops.count(curToken) > 0) nextToken();
			return;
		}
	}
	throw std::runtime_error("Unkown symbol");
}
