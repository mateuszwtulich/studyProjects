#include "pch.h"
#include "CDeleteCTable.h"


CDeleteCTable::CDeleteCTable(CCreateCTable *pcCreateTab)
{
	s_name = "DeleteCTable";
	s_command = "delete";
	pc_create = pcCreateTab;
}

CDeleteCTable::~CDeleteCTable()
{
	cout << "usuwam: " << s_name << endl;
}


void CDeleteCTable::vRunCommand()
{
	int i_num;
	cout << "Which CTable do you want to delete?";
	cin >> i_num;
	if (cin.good())
	{
		if (i_num >= 0 && i_num < pc_create->c_vec.size())
		{
			delete pc_create->c_vec[i_num];
			pc_create->c_vec.erase(pc_create->c_vec.begin() + i_num);
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
