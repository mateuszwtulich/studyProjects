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
	CKnapsackProblem(int *piWeightTable, int *piValueTable, int iWeight, int iNumOfItems);
	~CKnapsackProblem();

	double countResult(T *ptGenotype);
	double countWeight(T *ptGenotype);

	int getMaxWeight();
	int getNumberOfItems();
	int* getWeightTable();
	int* getValueTable();

	void setMaxWeight(int iMaxWeight);
	void setNumberOfItems(int iNumberOfItems);
	void setWeightTable(int *ptWeightTable);
	void setValueTable(int *ptValueTable);

private:
	int i_max_weight;
	int i_number_of_items;
	int *pi_weight_table;
	int *pi_value_table;
};
#endif