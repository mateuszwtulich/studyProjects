#include "pch.h"
#include "CKnapsackProblem.h"

template<class T>
CKnapsackProblem<T>::CKnapsackProblem()
{
	i_number_of_items = 0;
	d_max_weight = 0;
	pd_value_table = nullptr;
	pd_weight_table = nullptr;
}

template<class T>
CKnapsackProblem<T>::~CKnapsackProblem()
{
	delete[]pd_value_table;
	delete[]pd_weight_table;
}

template<class T>
CKnapsackProblem<T>::CKnapsackProblem(CKnapsackProblem &pcOther)
{
	this->i_number_of_items = pcOther.i_number_of_items;
	this->d_max_weight = pcOther.d_max_weight;
	pd_value_table = new double[i_number_of_items];
	pd_weight_table = new double[i_number_of_items];

	for (int i = 0; i < i_number_of_items; i++)
	{
		this->pd_value_table[i] = pcOther.pd_value_table[i];
		this->pd_weight_table[i] = pcOther.pd_weight_table[i];
	}
}

template<class T>
CKnapsackProblem<T>::CKnapsackProblem(double *pdWeightTable, double *pdValueTable, double dWeight, int iNumOfItems)
{
	i_number_of_items = iNumOfItems;
	d_max_weight = dWeight;
	pd_value_table = new double[i_number_of_items];
	pd_weight_table = new double[i_number_of_items];

	for (int i = 0; i < i_number_of_items; i++)
	{
		this->pd_value_table[i] = pdValueTable[i];
		this->pd_weight_table[i] = pdWeightTable[i];
	}
}

template<class T>
double CKnapsackProblem<T>::countResult(T *ptGenotype)
{
	double result = 0;

	for (int i = 0; i < this->i_number_of_items; i++)
	{
		result += ptGenotype[i] * pd_value_table[i];
	}

	return result;
}

template<class T>
double CKnapsackProblem<T>::countWeight(T *ptGenotype)
{
	double weight = 0;

	for (int i = 0; i < this->i_number_of_items; i++)
	{
		weight += ptGenotype[i] * pd_weight_table[i];
	}

	return weight;
}

template<class T>
double CKnapsackProblem<T>::getMaxWeight()
{
	return d_max_weight;
}

template<class T>
int CKnapsackProblem<T>::getNumberOfItems()
{
	return i_number_of_items;
}

template<class T>
double* CKnapsackProblem<T>::getWeightTable()
{
	return pd_value_table;
}

template<class T>
double* CKnapsackProblem<T>::getValueTable()
{
	return pd_value_table;
}

template<class T>
void CKnapsackProblem<T>::setMaxWeight(double dMaxWeight)
{
	this->d_max_weight = dMaxWeight;
}

template<class T>
void CKnapsackProblem<T>::setNumberOfItems(int iNumberOfItems)
{
	this->i_number_of_items = iNumberOfItems;
}

template<class T>
void CKnapsackProblem<T>::setWeightTable(double *pdWeightTable)
{
	delete pd_weight_table;
	pd_weight_table = pdWeightTable;
}

template<class T>
void CKnapsackProblem<T>::setValueTable(double *pdValueTable)
{
	delete pd_value_table;
	pd_value_table = pdValueTable;
}

template class CKnapsackProblem<int>;
template class CKnapsackProblem<bool>;
template class CKnapsackProblem<double>;