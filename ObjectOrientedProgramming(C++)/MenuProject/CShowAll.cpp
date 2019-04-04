#include "pch.h"
#include "CShowAll.h"


CShowAll::CShowAll(CCreateCTable *pcCreateTab)
{
	s_name = "ShowAll";
	s_command = "show";
	pc_create = pcCreateTab;
}

CShowAll::~CShowAll()
{
	cout << "usuwam: " << s_name << endl;
}

void CShowAll::vRunCommand()
{
	system("cls");

	for (int i = 0; i < pc_create->c_vec.size(); i++)
	{
		cout << endl << pc_create->c_vec[i]->toString();
	}
}
