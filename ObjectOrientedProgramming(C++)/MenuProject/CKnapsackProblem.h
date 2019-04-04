#pragma once
#ifndef CKnapsackProblem_h
#define CKnapsackProblem_h
#include <iostream>
using namespace std;

template <typename T>
class CKnapsackProblem
{
public:
	CKnapsackProblem();
	CKnapsackProblem(CKnapsackProblem &pcOther);
	CKnapsackProblem(double *pdWeightTable, double *pdValueTable, double dWeight, int iNumOfItems);
	~CKnapsackProblem();

	double countResult(T *ptGenotype);
	double countWeight(T *ptGenotype);

	double getMaxWeight();
	int getNumberOfItems();
	double* getWeightTable();
	double* getValueTable();

	void setMaxWeight(double iMaxWeight);
	void setNumberOfItems(int iNumberOfItems);
	void setWeightTable(double *pdWeightTable);
	void setValueTable(double *pdValueTable);

private:
	double d_max_weight;
	int i_number_of_items;
	double *pd_weight_table;
	double *pd_value_table;
};
#endif