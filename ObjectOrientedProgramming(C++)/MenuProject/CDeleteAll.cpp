#include "pch.h"
#include "CDeleteAll.h"


CDeleteAll::CDeleteAll(CCreateCTable *pcCreateTab)
{
	s_name = "DeleteAll";
	s_command = "deleteAll";
	pc_create = pcCreateTab;
}


CDeleteAll::~CDeleteAll()
{
	cout << "usuwam: " << s_name << endl;
}


void CDeleteAll::vRunCommand()
{
	for (int i = 0; i < pc_create->c_vec.size(); i++)
	{
		delete pc_create->c_vec[i];
	}

	pc_create->c_vec.clear();
}
