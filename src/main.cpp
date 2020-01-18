////////////////////////STANDART INCLUDES///////////////////////
#include <iostream>
#include <fstream>
#include <regex>
////////////////////////SPECIFY INCLUDES///////////////////////
#include "./../grammar/src/GrammarLexer.h"
#include "./../grammar/src/GrammarParser.h"

Grammar generateGrammar(char const* nameOfFile)
{
	std::ifstream file;
	file.open(nameOfFile);
	antlr4::ANTLRInputStream input(file);

	GrammarLexer lexer(&input);
	antlr4::CommonTokenStream tokens(&lexer);
	GrammarParser parser(&tokens);
	return parser.gram()->g;
}

int main(int argc, char** argv) {
	if (argc != 2)
	{
		std::cout << "Must be one argument, name of file with grammar" << std::endl;
	}
	auto grammar = generateGrammar(argv[1]);
	grammar.generate();
	return 0;
}