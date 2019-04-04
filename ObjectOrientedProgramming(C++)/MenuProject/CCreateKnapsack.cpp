#include "pch.h"
/*#include "CCreateKnapsack.h"

template<class T>
CCreateKnapsack<T>::CCreateKnapsack()
{
	s_name = "CreateKnapsackProblem";
	s_command = "knapsack";
}

template<class T>
CCreateKnapsack<T>::~CCreateKnapsack()
{
	cout << "usuwam: " << s_name << endl;

	for (int i = 0; i < c_vec.size(); i++)
	{
		delete c_vec[i];
	}
	c_vec.clear();
}

template<class T>
void CCreateKnapsack<T>::vRunCommand()
{
	int i_num;
	cout << "\nNumber of items: ";
	cin >> i_num;

	int *pi_value_tab = new int[i_num];
	int *pi_weight_tab = new int[i_num];
	int i_max_weight;

	if (cin.good())
	{
		cout << "\nEnter values: \n";
		for (int i = 0; i < i_num; i++)
		{
			cin >> pi_value_tab[i];
		}

		cout << "\nEnter weights: \n";
		for (int i = 0; i < i_num; i++)
		{
			cin >> pi_weight_tab[i];
		}

		cout << "\nEnter maximum weight of knapsack: ";
		cin >> i_max_weight;

		CKnapsackProblem<T> *pc_knapsack = new CKnapsackProblem<T>(pi_weight_tab, pi_value_tab, i_max_weight, i_num);
		c_vec.push_back(pc_knapsack);
		delete []pi_value_tab;
		delete []pi_weight_tab;
	}
	else
	{
		cout << "Wrong data!";
		cin.clear();
		cin.ignore();
	}
}
template class CCreateKnapsack<int>;
template class CCreateKnapsack<bool>;
template class CCreateKnapsack<double>;*/