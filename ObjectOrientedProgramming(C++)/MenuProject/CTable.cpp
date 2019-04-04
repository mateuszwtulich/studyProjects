#include "pch.h"
#include "CTable.h"


CTable::CTable()
{
	static int i_counter = DEFAULT_COUNTER;
	s_name = DEFAULT_CTABLE_NAME + to_string(i_counter);
	i_counter++;
	i_size = DEFAULT_CTABLE_SIZE;
	pi_ctable = new int[i_size];

	for (int i = 0; i < i_size; i++)
	{
		pi_ctable[i] = 0;
	}

	cout << BEZPARAMETRU << s_name << END_LINE;
}

CTable::CTable(string sName, int iSize)
{
	s_name = sName;
	i_size = iSize;
	pi_ctable = new int[i_size];

	for (int i = 0; i < i_size; i++)
	{
		pi_ctable[i] = 0;
	}

	cout << PARAMETR << s_name << END_LINE;
}

CTable::CTable(CTable &pcOther)
{
	s_name = pcOther.s_name + COPY;
	i_size = pcOther.i_size;
	pi_ctable = new int[i_size];

	for (int i = 0; i < i_size; i++)
	{
		pi_ctable[i] = pcOther.pi_ctable[i];
	}

	cout << KOPIUJ << s_name << END_LINE;
}

CTable::~CTable()
{
	cout << endl << DESTRUCTOR << s_name << END_LINE;
	delete[] pi_ctable;
}

string CTable::sGetName()
{
	return(s_name);
}

void CTable::vSetName(string sName)
{
	s_name = sName;
}

bool CTable::bSetSize(int iSize)
{
	if (iSize > 0)
	{
		int *pi_new_ctable = new int[iSize];

		for (int i = 0; i < iSize; i++)
		{
			if (i_size > i)
				pi_new_ctable[i] = pi_ctable[i];
			else
				pi_new_ctable[i] = 0;
		}
		i_size = iSize;

		delete pi_ctable;
		pi_ctable = pi_new_ctable;
		return true;
	}
	else
		return false;
}

bool CTable::bAdd(int &iPos, int &iVal)
{
	if (iPos >= 0 && iPos < i_size)
	{
		pi_ctable[iPos] = iVal;
		return true;
	}
	return false;
}

int CTable::iGet(int &iPos, int *piSucc)
{
	if (iPos >= 0 && iPos < i_size)
	{
		*piSucc = 1;
		return pi_ctable[iPos];
	}
	else
	{
		*piSucc = -1;
		return 0;
	}
}

void CTable::cCopy(CTable &pcOther)
{
	delete pi_ctable;
	this->i_size = pcOther.i_size;

	for (int i = 0; i < i_size; i++)
	{
		this->pi_ctable[i] = pcOther.pi_ctable[i];
	}
}

string CTable::toString()
{
	string s_string = "(<" + s_name + "> len: <" + to_string(i_size) + "> values: <";

	for (int i = 0; i < i_size - 1; i++)
	{
		s_string += to_string(pi_ctable[i]) + ", ";
	}
	s_string += to_string(pi_ctable[i_size - 1]) + ">)";

	return s_string;
}