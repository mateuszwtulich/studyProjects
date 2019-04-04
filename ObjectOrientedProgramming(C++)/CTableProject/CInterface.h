#pragma once
#include <vector>
#include "CTable.h"
class CInterface
{
public:
	CInterface();
	~CInterface();

	void vRun();
	
private:
	vector<CTable*> c_vec;
};

