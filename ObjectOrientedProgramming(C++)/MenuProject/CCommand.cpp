#include "pch.h"
#include "CCommand.h"

CCommand::CCommand()
{
}

CCommand::~CCommand()
{
}

string CCommand::s_get_scommand()
{
	return s_command;
}

string CCommand::s_get_name()
{
	return s_name;
}