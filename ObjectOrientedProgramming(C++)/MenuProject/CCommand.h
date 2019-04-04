#pragma once
#ifndef CCommand_h
#define CCommand_h
#include "CMenuItem.h"
class CCommand
{
public:
	CCommand();
	virtual ~CCommand();
	virtual void vRunCommand() = 0;
	string s_get_scommand();
	string s_get_name();

protected:
	string s_command;
	string s_name;
};

#endif // !1



