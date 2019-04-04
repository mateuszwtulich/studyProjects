#include "pch.h"
#include "CCopyCTable.h"


CCopyCTable::CCopyCTable(CCreateCTable *pcCreateTab)
{
	s_name = "CopyCTable";
	s_command = "copy";
	pc_create = pcCreateTab;
}


CCopyCTable::~CCopyCTable()
{
	cout << "usuwam: " << s_name << endl;
}

void CCopyCTable::vRunCommand() 
{
	int i_num;
	system("cls");

	cout << "Which CTable do you want to copy?";
	cin >> i_num;
	if (cin.good())
	{

		if (i_num >= 0 && pc_create ->c_vec.size())
		{
			CTable *pc_table = new CTable(*pc_create->c_vec[i_num]);
			pc_create->c_vec.push_back(pc_table);
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