#include "pch.h"
#include "CChangeName.h"


CChangeName::CChangeName(CCreateCTable *pcCreateTab)
{
	s_name = "ChangeName";
	s_command = "name";
	pc_create = pcCreateTab;
}


CChangeName::~CChangeName()
{
	cout << "usuwam: " << s_name << endl;
}

void CChangeName::vRunCommand()
{
	system("cls");
	int i_num;

	cout << "Which CTable's name do you want to change?";
	cin >> i_num;
	if (cin.good())
	{

		if (i_num >= 0 && pc_create->c_vec.size())
		{
			string s_string;

			cout << "\nWhat would be the new name?";
			cin >> s_string;

			pc_create->c_vec[i_num]->vSetName(s_string);
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