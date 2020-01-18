#pragma once
#include <stdexcept>
#include "lexer.hpp"
#include "Tools.hpp"

// Parser for pascal variables

struct parser
{
	lexer lex;

	void setInput(std::string const& input) { lex.setInput(input + "~"); }
	Result<Nothing> f_vs();
	Result<Nothing> f_v();
	Result<Nothing> f_s();
	Result<Nothing> f_block();
};

