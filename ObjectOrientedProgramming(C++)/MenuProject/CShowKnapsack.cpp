#include "pch.h"
/*#include "CShowKnapsack.h"

template <class T>
CShowKnapsack<T>::CShowKnapsack(CCreateKnapsack<T> *pcCreateKnap)
{
	s_name = "showKnapsack";
	s_command = "show";
	pc_knap = pcCreateKnap;
}

template <class T>
CShowKnapsack<T>::~CShowKnapsack()
{
	cout << "usuwam: " << s_name << endl;
}

template <class T>
void CShowKnapsack<T>::vRunCommand()
{
	system("cls");

	for (int i = 0; i < pc_knap->c_vec.size(); i++)
	{
		cout << "Value table: ";
		for (int j = 0; i < pc_knap->c_vec[i]->getValueTable().size(); j++)
		{
			cout << pc_knap->c_vec[i]->getValueTable()[j] << ", ";
		}

		cout << "Weight table: ";
		for (int j = 0; i < pc_knap->c_vec[i]->getWeightTable().size(); j++)
		{
			cout << pc_knap->c_vec[i]->getWeightTable()[j] << ", ";
		}

		cout << "Max weight: " << pc_knap->c_vec[i]->getMaxWeight();

	}
}

//template class CShowKnapsack<int>;
//template class CShowKnapsack<bool>;
//template class CShowKnapsack<double>;*/