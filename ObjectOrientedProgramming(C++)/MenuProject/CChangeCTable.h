#pragma once
#ifndef CChangeCTable_h
#define CChangeCTable_h
#include "CCommand.h"
#include "CTable.h"
#include "CCreateCTable.h"

class CChangeCTable: public CCommand
{
public:
	CChangeCTable(CCreateCTable *pcCreateTab);
	~CChangeCTable();
	void vRunCommand();
private:
	CCreateCTable *pc_create;
};
#endif

