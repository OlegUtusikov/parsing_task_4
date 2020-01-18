#pragma once
#include <stdexcept>
#include "lexer.hpp"
#include "Tools.hpp"


struct parser
{
	lexer lex;

	void setInput(std::string const& input) { lex.setInput(input + "~"); }
	Result<Nothing> f_nott();
	Result<Nothing> f_exprs();
	Result<Nothing> f_dis();
	Result<Nothing> f_expr();
	Result<Nothing> f_diss();
	Result<Nothing> f_temp();
	Result<Nothing> f_con();
	Result<Nothing> f_cons();
};

