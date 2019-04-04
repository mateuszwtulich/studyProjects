#pragma once
#ifndef CDeleteCTable_h
#define CDeleteCTable_h
#include "CCommand.h"
#include "CTable.h"
#include "CCreateCTable.h"

class CDeleteCTable : public CCommand
{
	public:
	CDeleteCTable(CCreateCTable *pcCreateTab);
	~CDeleteCTable();
	void vRunCommand();
private:
	CCreateCTable *pc_create;
};
#endif
