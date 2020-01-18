#pragma once
#include <regex>
#include <string>
#include <unordered_set>
#include <map>
#include <stdexcept>

enum Token
{
	XOR, WS, OR, VAR, NOT, RBR, LBR, AND, END
};

struct lexer
{
	lexer();
	void setInput(std::string const& input)
	{
		this->input = input;
		this->curPos = 0;
		nextToken();
	}
	void nextToken();
	Token getCurToken() const { return curToken; }
	std::string getCurTokenStr() const { return curTokenStr; }
	std::size_t getCurPos() const { return curPos; }

	std::string input { "" };
	Token curToken { Token::END };
	std::string curTokenStr { "" };
	std::size_t curPos { 0 };
	std::map<Token, std::regex> tokenReg;
	std::unordered_set<Token> drops { WS };
	static const int tokenCount = 8;
};
