#include "lexer.hpp"

lexer::lexer() : curPos(0)
{
	tokenReg[Token::WS] = std::regex("^[ \t\r\n]");
	tokenReg[Token::TYPE] = std::regex("^(\\binteger\\b|\\breal\\b|\\bboolean\\b|\\bchar\\b)");
	tokenReg[Token::SEMICOLON] = std::regex("^;");
	tokenReg[Token::VAR] = std::regex("^(\\bvar\\b)");
	tokenReg[Token::COMMA] = std::regex("^,");
	tokenReg[Token::COLON] = std::regex("^:");
	tokenReg[Token::NAME] = std::regex("^[A-Za-z]+");
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
