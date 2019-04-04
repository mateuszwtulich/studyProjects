#pragma once
#ifndef CSetSizeCTable_h
#define CSetSizeCTable_h
#include "CCommand.h"
#include "CTable.h"
#include "CCreateCTable.h"

class CSetSizeCTable : public CCommand
{
public:
	CSetSizeCTable(CCreateCTable *pcCreateTab);
	~CSetSizeCTable();
	void vRunCommand();
private:
	CCreateCTable *pc_create;
};
#endif

