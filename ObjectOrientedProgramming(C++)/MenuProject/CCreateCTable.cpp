#include "pch.h"
#include "CCreateCTable.h"

CCreateCTable::CCreateCTable()
{
	s_name = "CreateCTable";
	s_command = "create";
}

CCreateCTable::~CCreateCTable()
{
	for (int i = 0; i < c_vec.size(); i++)
	{
		delete c_vec[i];
	}

	cout << "usuwam: " << s_name << endl;
}

void CCreateCTable::vRunCommand() 
{
	int i_choice;

	cout << "\nIlosc tworzonych obiektow: " << endl;
	cin >> i_choice;
	system("cls");

	if (cin.good())
	{
		if (i_choice > 0)
		{
			for (int i = 0; i < i_choice; i++)
			{
				c_vec.push_back(new CTable());
			}
			cout << "Utworzono " << i_choice << " obiektow klasy CTable." << endl;
		}
		else
		{
			cout << "Podano niepoprawna liczbe." << endl;
		}
	}
	else
	{
		cout << "To nie jest liczba! Sprobuj jeszcze raz." << endl;
		cin.clear();
		cin.ignore();
	}

}

vector<CTable *> CCreateCTable::vecGetVector() {
	return c_vec;
}