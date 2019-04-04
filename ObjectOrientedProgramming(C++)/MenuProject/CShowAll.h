#pragma once
#ifndef CShowAll_h
#define CShowAll_h
#include "CCommand.h"
#include "CTable.h"
#include "CCreateCTable.h"

class CShowAll: public CCommand
{
public:
	CShowAll(CCreateCTable *pcCreateTab);
	~CShowAll();
	void vRunCommand();
private:
	CCreateCTable *pc_create;
};
#endif

