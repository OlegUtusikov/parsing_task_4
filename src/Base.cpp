#pragma once
#include "Base.hpp"

Base::Base(std::string const& name) : name(name) {}

Base::EntityType Base::getType() const
{
	return EntityType::BASE;
}