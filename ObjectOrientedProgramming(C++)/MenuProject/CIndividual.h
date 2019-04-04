#pragma once
#ifndef CIndividual_h
#define CIndividual_h
#define DEFAULT_SIZE 0
#define MUT_PROB 0.2
#define I_INTEGER_PROBLEM_MAX 3
#define I_DOUBLE_PROBLEM_MAX 2
#include "CKnapsackProblem.h"
#include <cstdlib>
#include <cstdio>
#include <ctime>
#include <string>
// przeci¹¿enie oparatorów = i +, tworzenie ró¿nych obiektów w CIndividual
template<class T>
class CIndividual
{
public:

	CIndividual();
	CIndividual(int iSize);
	CIndividual(CIndividual &pcOther);
	~CIndividual();

	string toString();
	double tFitness(CKnapsackProblem<T> &cMyKnap);
	void vMutate(double &dMutProb);
	void operator ++(int);
	void operator =(const CIndividual &cIndividual);
	CIndividual operator +(CIndividual &cIndivdual);
	CIndividual** cCross(CIndividual &cIndividual);

	T* getGenotype();
	void setGenotype(T &ptGenotype);

private:
	T *pt_genotype;
	int i_size;
};
#endif