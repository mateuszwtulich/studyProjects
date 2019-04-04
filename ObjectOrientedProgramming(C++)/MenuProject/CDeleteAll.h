#pragma once
#ifndef CDeleteAll_h
#define CDeleteAll_h
#include "CCommand.h"
#include "CTable.h"
#include "CCreateCTable.h"

class CDeleteAll: public CCommand
{
public:
	CDeleteAll(CCreateCTable *pcCreateTab);
	~CDeleteAll();
	void vRunCommand();
private:
	CCreateCTable *pc_create;
};
#endif