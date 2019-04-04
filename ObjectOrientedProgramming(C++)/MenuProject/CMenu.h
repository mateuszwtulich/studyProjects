#pragma once
#ifndef CMenu_h
#define CMenu_h
#include <vector>
#include "CMenuItem.h"

using namespace std;

class CMenu: public virtual CMenuItem
{
public:
	CMenu();
	CMenu(string sName, string sCommand);
	~CMenu();
	void vinitialize();
	void vRun();
	void vadd_item(CMenuItem *cmenu_item);
	void del();
	string sget_name();
	string sget_command();
private: 
	vector<CMenuItem *> cmenu_item_vector;
};
#endif
