
#include "pch.h"
#include <iostream>
#include "CTable.h"
#include "CInterface.h"

int main()
{
	/*CTable ctable("Stary", 20);
	cout << ctable.toString();
	int i_pos = 2;
	int i_val = 4;
	ctable.bAdd(i_pos, i_val);
	ctable.bSetSize(20);
	int *pi_succ = new int(1);
	cout << endl << ctable.iGet(i_pos, pi_succ);
	cout << endl << ctable.toString();*/

	CInterface *pc_interface = new CInterface();
	pc_interface->vRun();
	delete pc_interface;
}

