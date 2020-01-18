#pragma once
#include <vector>
#include "Base.hpp"

struct RightEntity
{
	std::string name { "" };
	std::string code { "" };

	RightEntity(std::string const& name, std::string const& code = "");
};

typedef std::vector<RightEntity> Rule;
struct NonTerminal : public Base
{
	std::vector<Rule> rules;
	std::string arguments { "" };
	std::string returns { "Nothing" };

	NonTerminal() {};
	NonTerminal(std::string const& name);
	void addRule(Rule const& rule);
	void addRule(Rule&& rule);

	EntityType getType() const;
};

using NonTerminalPtr = std::shared_ptr<NonTerminal>;