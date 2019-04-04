#pragma once
#ifndef CMenuCommand_h
#define CMenuCommand_h
#include "CMenuItem.h"
#include "CCommand.h"


class CMenuCommand: public CMenuItem
{
public:
	CMenuCommand();
	CMenuCommand(CCommand *pcCommand);
	~CMenuCommand();
	void vRun();
	string sget_name();
	string sget_command();
private:
	CCommand *p_ccommand;
};
#endif
