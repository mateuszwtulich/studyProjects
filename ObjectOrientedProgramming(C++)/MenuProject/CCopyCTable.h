#pragma once
#ifndef CCopyCTable_h
#define CCopyCTable_h
#include "CCommand.h"
#include "CTable.h"
#include "CCreateCTable.h"

class CCopyCTable: public CCommand
{
public:
	CCopyCTable(CCreateCTable *pcCreateTab);
	~CCopyCTable();
	void vRunCommand();
private:
	CCreateCTable *pc_create;
};
#endif

