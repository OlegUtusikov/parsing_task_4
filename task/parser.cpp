#include "parser.hpp"

Result<Nothing> parser::f_vs()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("vs"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case COLON:
		{
			if (lex.getCurToken() != Token::COLON) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> COLON { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(COLON.node);
			lex.nextToken();
			if (lex.getCurToken() != Token::TYPE) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> TYPE { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(TYPE.node);
			lex.nextToken();
			break;
		}
		case COMMA:
		{
			if (lex.getCurToken() != Token::COMMA) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> COMMA { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(COMMA.node);
			lex.nextToken();
			auto v = f_v();
			result.node->addChild(v.node);
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for vs");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_v()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("v"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case NAME:
		{
			if (lex.getCurToken() != Token::NAME) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> NAME { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(NAME.node);
			lex.nextToken();
			auto vs = f_vs();
			result.node->addChild(vs.node);
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for v");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_s()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("s"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case VAR:
		{
			if (lex.getCurToken() != Token::VAR) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> VAR { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(VAR.node);
			lex.nextToken();
			auto block = f_block();
			result.node->addChild(block.node);
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for s");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_block()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("block"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case NAME:
		{
			auto v = f_v();
			result.node->addChild(v.node);
			if (lex.getCurToken() != Token::SEMICOLON) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> SEMICOLON { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(SEMICOLON.node);
			lex.nextToken();
			auto block = f_block();
			result.node->addChild(block.node);
			break;
		}
		case END:
		{
			result.node->addChild(NodePtr(new Node("EPS")));
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for block");
	}
	result.out = out;
	return result;
}

