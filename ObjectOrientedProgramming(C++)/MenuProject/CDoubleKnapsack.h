#pragma once
#ifndef CDoubleKnapsack_h
#define CDoubleKnapsack_h
#include "CGeneticAlgorithm.h"
#include "CKnapsackProblem.h"
#include "CCommand.h"

class CDoubleKnapsack : public CCommand
{
public:
	CDoubleKnapsack();
	~CDoubleKnapsack();

	void vRunCommand();
};
#endif