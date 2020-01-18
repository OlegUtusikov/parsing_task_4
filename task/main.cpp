#include <iostream>
#include <string>
#include "parser.hpp"

void printDfs(NodePtr curNode, std::string prefix)
{
	std::cout << prefix << ">" << curNode->name << std::endl;
	for (auto const& ch : curNode->childs)
	{
		printDfs(ch, prefix + "|---");
	}
}

int main(int argc, char** argv)
{
	if (argc != 3)
	{
		std::cout << "Pleas give me a string and mode" << std::endl;
		return 0;
	}

	parser p;
	p.setInput(argv[1]);
	try
	{
		auto res = p.f_s();
		std::cout << "OK" << std::endl;
		if (std::strcmp("print", argv[2]) == 0)
		{
			printDfs(res.node, "");
		}
	}
	catch(const std::exception& e)
	{
		std::cerr << "FAILED Cause: " << e.what() << std::endl;
	}
}