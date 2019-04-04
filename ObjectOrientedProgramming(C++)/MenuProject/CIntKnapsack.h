#pragma once
#ifndef CIntKnapsack_h
#define CIntKnapsack_h
#include "CGeneticAlgorithm.h"
#include "CKnapsackProblem.h"
#include "CCommand.h"

class CIntKnapsack : public CCommand
{
public:
	CIntKnapsack();
	~CIntKnapsack();

	void vRunCommand();
};
#endif
