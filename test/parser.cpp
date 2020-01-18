#include "parser.hpp"

Result<Nothing> parser::f_nott()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("nott"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case VAR:
		{
			auto temp = f_temp();
			result.node->addChild(temp.node);
			break;
		}
		case LBR:
		{
			auto temp = f_temp();
			result.node->addChild(temp.node);
			break;
		}
		case NOT:
		{
			if (lex.getCurToken() != Token::NOT) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> NOT { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(NOT.node);
			lex.nextToken();
			auto temp = f_temp();
			result.node->addChild(temp.node);
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for nott");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_exprs()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("exprs"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case XOR:
		{
			if (lex.getCurToken() != Token::XOR) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> XOR { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(XOR.node);
			lex.nextToken();
			auto expr = f_expr();
			result.node->addChild(expr.node);
			break;
		}
		case RBR:
		case END:
		{
			result.node->addChild(NodePtr(new Node("EPS")));
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for exprs");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_dis()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("dis"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case VAR:
		{
			auto con = f_con();
			result.node->addChild(con.node);
			auto diss = f_diss();
			result.node->addChild(diss.node);
			break;
		}
		case LBR:
		{
			auto con = f_con();
			result.node->addChild(con.node);
			auto diss = f_diss();
			result.node->addChild(diss.node);
			break;
		}
		case NOT:
		{
			auto con = f_con();
			result.node->addChild(con.node);
			auto diss = f_diss();
			result.node->addChild(diss.node);
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for dis");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_expr()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("expr"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case VAR:
		{
			auto dis = f_dis();
			result.node->addChild(dis.node);
			auto exprs = f_exprs();
			result.node->addChild(exprs.node);
			break;
		}
		case LBR:
		{
			auto dis = f_dis();
			result.node->addChild(dis.node);
			auto exprs = f_exprs();
			result.node->addChild(exprs.node);
			break;
		}
		case NOT:
		{
			auto dis = f_dis();
			result.node->addChild(dis.node);
			auto exprs = f_exprs();
			result.node->addChild(exprs.node);
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for expr");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_diss()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("diss"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case OR:
		{
			if (lex.getCurToken() != Token::OR) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> OR { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(OR.node);
			lex.nextToken();
			auto dis = f_dis();
			result.node->addChild(dis.node);
			break;
		}
		case RBR:
		case XOR:
		case END:
		{
			result.node->addChild(NodePtr(new Node("EPS")));
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for diss");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_temp()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("temp"));
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
			break;
		}
		case LBR:
		{
			if (lex.getCurToken() != Token::LBR) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> LBR { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(LBR.node);
			lex.nextToken();
			auto expr = f_expr();
			result.node->addChild(expr.node);
			if (lex.getCurToken() != Token::RBR) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> RBR { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(RBR.node);
			lex.nextToken();
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for temp");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_con()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("con"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case VAR:
		{
			auto nott = f_nott();
			result.node->addChild(nott.node);
			auto cons = f_cons();
			result.node->addChild(cons.node);
			break;
		}
		case LBR:
		{
			auto nott = f_nott();
			result.node->addChild(nott.node);
			auto cons = f_cons();
			result.node->addChild(cons.node);
			break;
		}
		case NOT:
		{
			auto nott = f_nott();
			result.node->addChild(nott.node);
			auto cons = f_cons();
			result.node->addChild(cons.node);
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for con");
	}
	result.out = out;
	return result;
}

Result<Nothing> parser::f_cons()
{
	Result<Nothing> result;
	result.node = NodePtr(new Node("cons"));
	Nothing out;
	Token curToken = lex.getCurToken();
	switch(curToken)
	{
		case AND:
		{
			if (lex.getCurToken() != Token::AND) throw std::runtime_error("Inccorect token: " + std::to_string(lex.getCurToken()) + " Str: " + lex.getCurTokenStr());
			Result<std::string> AND { NodePtr(new Node(lex.getCurTokenStr())), lex.getCurTokenStr() };
			result.node->addChild(AND.node);
			lex.nextToken();
			auto con = f_con();
			result.node->addChild(con.node);
			break;
		}
		case RBR:
		case XOR:
		case OR:
		case END:
		{
			result.node->addChild(NodePtr(new Node("EPS")));
			break;
		}
		default:
			throw std::runtime_error("Haven't rule for cons");
	}
	result.out = out;
	return result;
}

