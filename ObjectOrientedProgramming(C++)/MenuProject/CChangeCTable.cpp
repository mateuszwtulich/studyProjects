#include "pch.h"
#include "CChangeCTable.h"


CChangeCTable::CChangeCTable(CCreateCTable *pcCreateTab)
{
	s_name = "ChangeCTable";
	s_command = "change";
	pc_create = pcCreateTab;
}


CChangeCTable::~CChangeCTable()
{
	cout << "usuwam: " << s_name << endl;
}

void CChangeCTable::vRunCommand()
{
	int i_num;
	system("cls");

	cout << "Which CTable do you want to change?";
	cin >> i_num;

	if (cin.good())
	{

		if (i_num >= 0 && pc_create->c_vec.size())
		{
			int i_pos;
			int i_value;
			cout << "\nWhat would be the position of the new value?";
			cin >> i_pos;

			cout << "\nWhat would be the new value?";
			cin >> i_value;

			if (pc_create->c_vec[i_num]->bAdd(i_pos, i_value))
				cout << "\nDone!";
			else
				cout << "\nWrong position!";
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