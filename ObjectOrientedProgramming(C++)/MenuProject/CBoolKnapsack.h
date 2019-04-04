#pragma once
#ifndef CBoolKnapsack_h
#define CBoolKnapsack_h
#include "CGeneticAlgorithm.h"
#include "CKnapsackProblem.h"
#include "CCommand.h"

class CBoolKnapsack : public CCommand
{
public:
	CBoolKnapsack();
	~CBoolKnapsack();

	void vRunCommand();
};
#endif

