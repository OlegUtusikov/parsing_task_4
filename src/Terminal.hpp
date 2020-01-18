#pragma once
#include "Base.hpp"

struct Terminal : public Base
{
	std::string regexp;

	Terminal() {};
	Terminal(std::string const& name, std::string const& regexp);
	EntityType getType() const;
};

using TerminalPtr = std::shared_ptr<Terminal>;