#include "pch.h"
#include "CIndividual.h"

template<class T>
CIndividual<T>::CIndividual()
{
	i_size = DEFAULT_SIZE;
	pt_genotype = nullptr;
}

template<>
CIndividual<int>::CIndividual(int iSize)
{
	i_size = iSize;
	pt_genotype = new int[i_size];

	for (int i = 0; i < i_size; i++)
	{
		pt_genotype[i] = rand() % I_INTEGER_PROBLEM_MAX;;
	}
}

template<>
CIndividual<double>::CIndividual(int iSize)
{
	i_size = iSize;
	pt_genotype = new double[i_size];

	for (int i = 0; i < i_size; i++)
	{
		pt_genotype[i] = ((double)rand() / RAND_MAX) * I_DOUBLE_PROBLEM_MAX;
	}
}

template<class T>
CIndividual<T>::CIndividual(CIndividual &pcOther)
{
	i_size = pcOther.i_size;
	pt_genotype = new T[i_size];

	for (int i = 0; i < i_size; i++)
	{
		pt_genotype[i] = pcOther.pt_genotype[i];
	}
}


template<>
CIndividual<bool>::CIndividual(int iSize)
{
	i_size = iSize;
	pt_genotype = new bool[i_size];

	for (int i = 0; i < i_size; i++)
	{
		if (rand() % 2 == true)
			pt_genotype[i] = false;
		else
			pt_genotype[i] = true;;;
	}
}

template<class T>
CIndividual<T>::~CIndividual()
{
	delete pt_genotype;
}

template<class T>
T* CIndividual<T>::getGenotype()
{
	return pt_genotype;
}

template<class T>
void CIndividual<T>::setGenotype(T &ptGenotype)
{
	pt_genotype = &ptGenotype;
}

template<class T>
double CIndividual<T>::tFitness(CKnapsackProblem<T> &cMyKnap)
{
	if (this->pt_genotype == nullptr || cMyKnap.countWeight(this->pt_genotype) > cMyKnap.getMaxWeight())
		return 0;
	else return cMyKnap.countResult(this->pt_genotype);
}

template<class T>
void CIndividual<T>::vMutate(double &dMutProb)
{
	for (int i = 0; i < i_size; i++)
	{
		if ((double)rand() / RAND_MAX < dMutProb)
		{
			if (pt_genotype[i] == true)
				pt_genotype[i] = false;
			else
				pt_genotype[i] = true;
			cout << endl << endl << "MUTATION!!!";
		}
	}
}

template<class T>
void CIndividual<T>::operator =(const CIndividual &cIndividual)
{
	for (int i = 0; i < i_size; i++)
	{
		pt_genotype[i] = cIndividual.pt_genotype[i];
	}
}

template<>
void CIndividual<bool>::operator ++(int)
{
	for (int i = 0; i < i_size; i++)
	{
		if ((double)rand() / RAND_MAX < MUT_PROB)
		{
			if (pt_genotype[i] == true)
				pt_genotype[i] = false;
			else
				pt_genotype[i] = true;
			cout << endl << endl << "MUTATION!!!";
		}
	}
}

template<>
void CIndividual<int>::operator ++(int)
{
	for (int i = 0; i < i_size; i++)
	{
		if ((double)rand() / RAND_MAX < MUT_PROB)
		{
			this->pt_genotype[i] = rand() % I_INTEGER_PROBLEM_MAX;
			cout << endl << endl << "MUTATION!!!";
		}
	}
}

template<>
void CIndividual<double>::operator ++(int)
{
	for (int i = 0; i < i_size; i++)
	{
		if ((double)rand() / RAND_MAX < MUT_PROB)
		{
			this->pt_genotype[i] = ((double)rand() / RAND_MAX) * I_DOUBLE_PROBLEM_MAX;
			cout << endl << endl << "MUTATION!!!";
		}
	}
}

template<class T>
CIndividual<T> CIndividual<T>::operator +(CIndividual &cIndividual)
{
	CIndividual pc_child(i_size);
	int i_place_to_divide = rand() % (i_size - 1);

	for (int j = 0; j < i_size; j++)
	{
		if (j <= i_place_to_divide)
			pc_child.pt_genotype[j] = pt_genotype[j];
		else
			pc_child.pt_genotype[j] = cIndividual.pt_genotype[j];
	}

	return pc_child;
}

template<class T>
CIndividual<T>** CIndividual<T>::cCross(CIndividual &cIndividual)
{
	CIndividual<T> *pc_frist_child = new CIndividual<T>(i_size);
	CIndividual<T> *pc_second_child = new CIndividual<T>(i_size);

	int i_place_to_divide = rand() % (i_size - 1);

	for (int j = 0; j < i_size; j++)
	{
		if (j <= i_place_to_divide)
		{
			pc_frist_child->pt_genotype[j] = pt_genotype[j];
			pc_second_child->pt_genotype[j] = cIndividual.pt_genotype[j];
		}
		else
		{
			pc_frist_child->pt_genotype[j] = cIndividual.pt_genotype[j];
			pc_second_child->pt_genotype[j] = pt_genotype[j];
		}
	}

	CIndividual<T> **c_children = new CIndividual<T>*[2];
	c_children[0] = pc_frist_child;
	c_children[1] = pc_second_child;

	return c_children;
}

template<class T>
string CIndividual<T>::toString()
{
	string s_some = "";

	for (int i = 0; i < i_size; i++)
	{
		s_some += (" " + to_string(pt_genotype[i]));
	}

	s_some += ";";
	return s_some;
}

template class CIndividual<int>;
template class CIndividual<bool>;
template class CIndividual<double>;