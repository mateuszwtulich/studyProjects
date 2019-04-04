#include "pch.h"
#include "CGeneticAlgorithm.h"

template<class T>
CGeneticAlgorithm<T>::CGeneticAlgorithm(CKnapsackProblem<T> &cMyKnapProblem)
{
	c_my_knaps_problem = &cMyKnapProblem;
	d_cross_prob = D_CROSS_PROPABILITY;
	d_mut_prob = D_MUTATION_PROPABILITY;
	i_popul_size = NUMBER_OF_POPULATION;
}

template<class T>
CGeneticAlgorithm<T>::CGeneticAlgorithm(CGeneticAlgorithm &pcOther)
{
	c_my_knaps_problem = new CKnapsackProblem<T>();
	*c_my_knaps_problem = *pcOther.c_my_knaps_problem;
	this->d_cross_prob = pcOther.d_cross_prob;
	this->d_mut_prob = pcOther.d_mut_prob;
	this->i_popul_size = pcOther.i_popul_size;
}

template<class T>
CGeneticAlgorithm<T>::~CGeneticAlgorithm()
{
	delete c_my_knaps_problem;
	delete c_best_solution;
}

template<class T>
double CGeneticAlgorithm<T>::getBestFittness()
{
	return c_best_solution->tFitness(*c_my_knaps_problem);
}

template<class T>
CIndividual<T> CGeneticAlgorithm<T>::getBestSolution()
{
	return *c_best_solution;
}

template<class T>
void CGeneticAlgorithm<T>::vRun()
{
	int static i_counter = START_OF_COUNTING;
	double d_start = clock();
	cout << "\n\nCzas: " << d_start;
	double d_duration = D_DURATION_TIME;

	create_starting_pop();
	c_best_solution = new CIndividual<T>();
	//while (i_counter != NUMBER_OF_ITERATIONS)
	while(clock() < d_duration + d_start)
	{
		cout << endl << endl << "##############################" << endl << "\tITERATION " << i_counter + 1 << endl << endl;
		v_run_algorithm();
		i_counter++;
	}
}

template<>
void CGeneticAlgorithm<bool>::create_starting_pop()
{
	int i_size = c_my_knaps_problem->getNumberOfItems();

	for (int i = 0; i < i_popul_size; i++)
	{
		CIndividual<bool> *pc_indi = new CIndividual<bool>(i_size);
		bool *pb_gen = new bool[i_size];

		for (int j = 0; j < i_size; j++)
		{
			if (rand() % 2 == true)
				pb_gen[j] = false;
			else
				pb_gen[j] = true;
		}

		pc_indi->setGenotype(*pb_gen);
		c_vector_current_pop.push_back(pc_indi);
	}

	cout << "First creation: ";
	print_current_sit();
}

template<>
void CGeneticAlgorithm<int>::create_starting_pop()
{
	int i_size = c_my_knaps_problem->getNumberOfItems();

	for (int i = 0; i < i_popul_size; i++)
	{
		CIndividual<int> *pc_indi = new CIndividual<int>(i_size);
		int *pi_gen = new int[i_size];

		for (int j = 0; j < i_size; j++)
		{
			pi_gen[j] = rand() % I_INTEGER_PROBLEM_MAX;
		}

		pc_indi->setGenotype(*pi_gen);
		c_vector_current_pop.push_back(pc_indi);
	}

	cout << "First creation: ";
	print_current_sit();
}

template<>
void CGeneticAlgorithm<double>::create_starting_pop()
{
	int i_size = c_my_knaps_problem->getNumberOfItems();

	for (int i = 0; i < i_popul_size; i++)
	{
		CIndividual<double> *pc_indi = new CIndividual<double>(i_size);
		double *pd_gen = new double[i_size];

		for (int j = 0; j < i_size; j++)
		{
			pd_gen[j] = ((double)rand() / RAND_MAX) * I_DOUBLE_PROBLEM_MAX;
		}

		pc_indi->setGenotype(*pd_gen);
		c_vector_current_pop.push_back(pc_indi);
	}

	cout << "First creation: ";
	print_current_sit();
}

template<class T>
void CGeneticAlgorithm<T>::v_run_algorithm()
{
	find_best_solution();

	for (int i = 0; i < i_popul_size / 2; i++)
	{
		CIndividual<T> *pc_first_parent;
		CIndividual<T> *pc_second_parent;
		pc_first_parent = search_parent();
		pc_second_parent = search_parent();

		if ((double)rand() / RAND_MAX < d_cross_prob)
		{
			CIndividual<T> *pc_second_child = (*pc_first_parent + *pc_second_parent);
			CIndividual<T> *pc_first_child = (*pc_second_parent + *pc_first_parent);
			c_vector_new_pop.push_back(pc_second_child);
			c_vector_new_pop.push_back(pc_first_child);
			cout << endl << "In cross1: " << (pc_second_child)->toString();
			cout << "In cross2: " << (pc_first_child)->toString();

			delete pc_first_parent;
			delete pc_second_parent;

			/*CIndividual **c_helper_tab = new CIndividual*[2];
			c_helper_tab = pc_first_parent->cCross(*pc_second_parent);
			c_vector_new_pop.push_back(c_helper_tab[0]);
			c_vector_new_pop.push_back(c_helper_tab[1]);

			cout << endl << "In cross1: " << c_helper_tab[0]->toString();
			cout << "In cross2: " << c_helper_tab[1]->toString();
			delete pc_first_parent;
			delete pc_second_parent;
			delete c_helper_tab;
			*/
		}
		else
		{
			c_vector_new_pop.push_back(pc_first_parent);
			c_vector_new_pop.push_back(pc_second_parent);
		}
	}

	for (int i = 0; i < i_popul_size; i++)
	{
		delete c_vector_current_pop[i];
	}

	c_vector_current_pop.clear();

	for (int i = 0; i < i_popul_size; i++)
	{
		c_vector_current_pop.push_back(c_vector_new_pop[i]);
	}

	c_vector_new_pop.clear();

	cout << endl << endl << "After crossing: ";
	print_current_sit();

	for (int i = 0; i < i_popul_size; i++)
	{
		if ((double)rand() / RAND_MAX < d_mut_prob)
			//c_vector_current_pop[i]->vMutate(d_mut_prob);
			(*c_vector_current_pop[i])++;
	}

	cout << endl << endl << "After mutation: ";

	print_current_sit();
}

template<class T>
CIndividual<T>* CGeneticAlgorithm<T>::search_parent()
{
	CIndividual<T> *pc_first_parent = new CIndividual<T>(*c_vector_current_pop[rand() % i_popul_size]);
	CIndividual<T> *pc_second_parent = new CIndividual<T>(*c_vector_current_pop[rand() % i_popul_size]);

	if (pc_first_parent->tFitness(*c_my_knaps_problem) < pc_second_parent->tFitness(*c_my_knaps_problem))
	{
		delete pc_first_parent;
		pc_first_parent = pc_second_parent;
	}
	else {
		delete pc_second_parent;
	}

	cout << endl << "Parent: " << pc_first_parent->toString();

	return pc_first_parent;
}

template<class T>
void CGeneticAlgorithm<T>::print_current_sit()
{
	for (int i = 0; i < i_popul_size; i++)
	{
		cout << endl << c_vector_current_pop[i]->toString();
	}
}

template<class T>
void CGeneticAlgorithm<T>::find_best_solution()
{
	for (int i = 0; i < i_popul_size; i++)
	{
		if (c_vector_current_pop[i]->tFitness(*c_my_knaps_problem) > c_best_solution->tFitness(*c_my_knaps_problem))
		{
			delete c_best_solution;
			c_best_solution = new CIndividual<T>(*c_vector_current_pop[i]);

		}
	}
}
template class CGeneticAlgorithm<int>;
template class CGeneticAlgorithm<bool>;
template class CGeneticAlgorithm<double>;