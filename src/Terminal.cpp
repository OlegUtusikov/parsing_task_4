#include "Terminal.hpp"

Terminal::Terminal(std::string const& name, std::string const& regexp) : Base(name), regexp(regexp) {}

Terminal::EntityType Terminal::getType() const
{
	return EntityType::TERMINAL;
}