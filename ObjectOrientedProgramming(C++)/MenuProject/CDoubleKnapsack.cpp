#include "pch.h"
#include "CDoubleKnapsack.h"

CDoubleKnapsack::CDoubleKnapsack()
{
	s_name = "DoubleKnapsack";
	s_command = "double";
}


CDoubleKnapsack::~CDoubleKnapsack()
{
	cout << "usuwam: " << s_name << endl;
}

void CDoubleKnapsack::vRunCommand()
{
	int i_num;
	cout << "\nNumber of items: ";
	cin >> i_num;

	double *pd_value_tab = new double[i_num];
	double *pd_weight_tab = new double[i_num];
	double d_max_weight;

	if (cin.good())
	{
		cout << "\nEnter values: \n";
		for (int i = 0; i < i_num; i++)
		{
			cin >> pd_value_tab[i];
		}

		cout << "\nEnter weights: \n";
		for (int i = 0; i < i_num; i++)
		{
			cin >> pd_weight_tab[i];
		}

		cout << "\nEnter maximum weight of knapsack: ";
		cin >> d_max_weight;

		CKnapsackProblem<double> *pc_knapsack = new CKnapsackProblem<double>(pd_weight_tab, pd_value_tab, d_max_weight, i_num);
		CGeneticAlgorithm<double> my_gen(*pc_knapsack);
		my_gen.vRun();
		cout << "\nBest solution: " << my_gen.getBestSolution().toString() << " Result: " << my_gen.getBestFittness();
	}
	else
	{
		cout << "\nWrong data!";
		cin.clear();
		cin.ignore();
	}
}