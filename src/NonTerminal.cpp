#pragma once
#include "NonTerminal.hpp"

RightEntity::RightEntity(std::string const& name, std::string const& code) : name(name), code(code) {}
NonTerminal::NonTerminal(std::string const& name) : Base(name) {}

void NonTerminal::addRule(Rule const& rule)
{
	rules.push_back(rule);
}

void NonTerminal::addRule(Rule&& rule)
{
	rules.emplace_back(std::move(rule));
}

NonTerminal::EntityType NonTerminal::getType() const
{
	return EntityType::NONTERMINAL;
}