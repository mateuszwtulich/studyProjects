#pragma once
#ifndef CChangeName_h
#define CChangeName_h
#include "CCommand.h"
#include "CTable.h"
#include "CCreateCTable.h"

class CChangeName: public CCommand
{
public:
	CChangeName(CCreateCTable *pcCreateTab);
	~CChangeName();
	void vRunCommand();
private:
	CCreateCTable *pc_create;
};
#endif
