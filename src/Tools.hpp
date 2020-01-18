#pragma once

#include <memory>
#include <vector>

struct Node;
using NodePtr = std::shared_ptr<Node>;

struct Node
{
	std::string name;
	std::vector<NodePtr> childs;

	Node(std::string const& name) : name(name) {}
	void addChild(NodePtr const& child) { childs.push_back(child); }
	void addChild(NodePtr&& child) { childs.emplace_back(std::move(child)); };
};

template <typename T>
struct Result
{
	NodePtr node;
	T out;
};

struct Nothing
{
	// It's struct means that returns is empty
};

