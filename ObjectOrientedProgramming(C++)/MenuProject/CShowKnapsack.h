/*#pragma once
#ifndef CShowKnapsack_h
#define CShowKnapsack_h
#include "CCreateKnapsack.h"

template <class T>
class CShowKnapsack : public CCommand
{
public:
	CShowKnapsack(CCreateKnapsack<T> *pcCreateKnap);
	~CShowKnapsack();

	void vRunCommand();
private:
	CCreateKnapsack<T> *pc_knap;
};
#endif

