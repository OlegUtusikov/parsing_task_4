#include <iostream>
#include "parser.hpp"

int main()
{
	parser p;
	p.setInput("not a"); 
	auto res = p.f_expr();
}