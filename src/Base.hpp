#pragma once
#include <string>
#include <memory>

struct Base
{
	enum EntityType
	{
		BASE,
		TERMINAL,
		NONTERMINAL
	};

	std::string name;

	Base() {};
	virtual ~Base() = default;
	Base(std::string const& name);
	virtual EntityType getType() const;
};

using BasePtr = std::shared_ptr<Base>;