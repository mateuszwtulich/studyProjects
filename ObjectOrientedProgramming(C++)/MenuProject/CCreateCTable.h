#pragma once
#ifndef CCreateCTable_h
#define CCreateCTable_h
#include "CCommand.h"
#include "CTable.h"
#include <vector>

class CCreateCTable : public CCommand
{
	friend class CDeleteCTable;
	friend class CSetSizeCTable;
	friend class CDeleteAll;
	friend class CChangeName;
	friend class CCopyCTable;
	friend class CShowAll;
	friend class CChangeCTable;
public:
	CCreateCTable();
	~CCreateCTable();
	void vRunCommand(); 
	vector<CTable *> vecGetVector();
private: 
	vector<CTable *> c_vec;
};
#endif
