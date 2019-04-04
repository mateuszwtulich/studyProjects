#ifndef CGeneticAlgorithm_h
#define CGeneticAlgorithm_h
#define NUMBER_OF_ITERATIONS 10
#define NUMBER_OF_POPULATION 10
#define START_OF_COUNTING 0
#define D_CROSS_PROPABILITY 0.7
#define D_MUTATION_PROPABILITY 0.2
#define D_DURATION_TIME 4000
#define I_INTEGER_PROBLEM_MAX 3
#define I_DOUBLE_PROBLEM_MAX 2
#include <vector>
#include <cstdlib>
#include <cstdio>
#include <ctime>
#include <string>
#include "CKnapsackProblem.h"
#include "CIndividual.h"

template<class T>
class CGeneticAlgorithm
{
public:
	CGeneticAlgorithm(CKnapsackProblem<T> &cMyKnapProblem);
	CGeneticAlgorithm(CGeneticAlgorithm &pcOther);
	~CGeneticAlgorithm();

	double getBestFittness();
	CIndividual<T> getBestSolution();
	void vRun();

private:
	void v_run_algorithm();
	void create_starting_pop();
	void print_current_sit();
	void find_best_solution();
	CIndividual<T>* search_parent();

	CKnapsackProblem<T> *c_my_knaps_problem;
	int i_popul_size;
	double d_cross_prob;
	double d_mut_prob;
	CIndividual<T> *c_best_solution;
	vector<CIndividual<T>*> c_vector_current_pop;
	vector<CIndividual<T>*> c_vector_new_pop;
};
#endif