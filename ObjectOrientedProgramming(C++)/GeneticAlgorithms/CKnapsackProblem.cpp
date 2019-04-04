#include "pch.h"
#include "CKnapsackProblem.h"

template<class T>
CKnapsackProblem<T>::CKnapsackProblem()
{
	i_number_of_items = 0;
	i_max_weight = 0;
	pi_value_table = nullptr;
	pi_weight_table = nullptr;
}

template<class T>
CKnapsackProblem<T>::~CKnapsackProblem()
{
	delete[]pi_value_table;
	delete[]pi_weight_table;
}

template<class T>
CKnapsackProblem<T>::CKnapsackProblem(CKnapsackProblem &pcOther)
{
	this->i_number_of_items = pcOther.i_number_of_items;
	this->i_max_weight = pcOther.i_max_weight;
	pi_value_table = new int[i_number_of_items];
	pi_weight_table = new int[i_number_of_items];

	for (int i = 0; i < i_number_of_items; i++)
	{
		this->pi_value_table[i] = pcOther.pi_value_table[i];
		this->pi_weight_table[i] = pcOther.pi_weight_table[i];
	}
}

template<class T>
CKnapsackProblem<T>::CKnapsackProblem(int *piWeightTable, int *piValueTable, int iWeight, int iNumOfItems)
{
	i_number_of_items = iNumOfItems;
	i_max_weight = iWeight;
	pi_value_table = new int[i_number_of_items];
	pi_weight_table = new int[i_number_of_items];

	for (int i = 0; i < i_number_of_items; i++)
	{
		this->pi_value_table[i] = piValueTable[i];
		this->pi_weight_table[i] = piWeightTable[i];
	}
}

template<class T>
double CKnapsackProblem<T>::countResult(T *ptGenotype)
{
	double result = 0;

	for (int i = 0; i < this->i_number_of_items; i++)
	{
		result += ptGenotype[i] * pi_value_table[i];
	}

	return result;
}

template<class T>
double CKnapsackProblem<T>::countWeight(T *ptGenotype)
{
	double weight = 0;

	for (int i = 0; i < this->i_number_of_items; i++)
	{
		weight += ptGenotype[i] * pi_weight_table[i];
	}

	return weight;
}

template<class T>
int CKnapsackProblem<T>::getMaxWeight()
{
	return i_max_weight;
}

template<class T>
int CKnapsackProblem<T>::getNumberOfItems()
{
	return i_number_of_items;
}

template<class T>
int* CKnapsackProblem<T>::getWeightTable()
{
	return pi_value_table;
}

template<class T>
int* CKnapsackProblem<T>::getValueTable()
{
	return pi_value_table;
}

template<class T>
void CKnapsackProblem<T>::setMaxWeight(int iMaxWeight)
{
	this->i_max_weight = iMaxWeight;
}

template<class T>
void CKnapsackProblem<T>::setNumberOfItems(int iNumberOfItems)
{
	this->i_number_of_items = iNumberOfItems;
}

template<class T>
void CKnapsackProblem<T>::setWeightTable(int *piWeightTable)
{
	delete pi_weight_table;
	pi_weight_table = piWeightTable;
}

template<class T>
void CKnapsackProblem<T>::setValueTable(int *piValueTable)
{
	delete pi_value_table;
	pi_value_table = piValueTable;
}

template class CKnapsackProblem<int>;
template class CKnapsackProblem<bool>;
template class CKnapsackProblem<double>;