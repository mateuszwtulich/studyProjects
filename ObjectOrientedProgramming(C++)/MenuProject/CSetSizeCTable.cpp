#include "pch.h"
#include "CSetSizeCTable.h"
#include "CCreateCTable.h"


CSetSizeCTable::CSetSizeCTable(CCreateCTable *pcCreateTab)
{
	s_name = "CSetSizeCTable";
	s_command = "size";
	pc_create = pcCreateTab;
}

CSetSizeCTable::~CSetSizeCTable()
{
	cout << "usuwam: " << s_name << endl;
}

void CSetSizeCTable::vRunCommand() 
{
	int i_num;
	system("cls");

	cout << "Which CTable's size do you want to change?";
	cin >> i_num;

	if (cin.good())
	{
		if (i_num >= 0 && i_num < pc_create->c_vec.size())
		{
			int i_size;
			cout << "\nWhat will be the size?";
			cin >> i_size;
			if (pc_create->c_vec[i_num]->bSetSize(i_size))
				cout << "\nDone!";
			else
				cout << "Uncorrect size!";
		}
		else
			cout << "Uncorrect number!";
	}
	else
	{
		cout << "\nWrong data!";
		cin.clear();
		cin.ignore();
	}
}


