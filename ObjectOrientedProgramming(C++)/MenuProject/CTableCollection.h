#pragma once
#include "CTable.h"
class CTableCollection
{
public:
	CTableCollection();
	~CTableCollection();
	vector<CTable *> getVector();
	void v_addCTable(CTable* cTable);
	void v_deleteCTable();
	int i_size();
private: 
	vector<CTable *> vec_collection;
};

