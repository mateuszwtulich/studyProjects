#include "pch.h"
#include "CMenuCommand.h"


CMenuCommand::CMenuCommand()
{
	s_name = "Default name";
	s_command = "default";
}

CMenuCommand::CMenuCommand(CCommand *pcCommand) 
{
	s_name = pcCommand->s_get_name();
	s_command = pcCommand->s_get_scommand();
	p_ccommand = pcCommand;
}


CMenuCommand::~CMenuCommand()
{
	delete p_ccommand;
	cout << "usuwam: " << s_name << endl;
}

void CMenuCommand::vRun()
{
	if(p_ccommand!=nullptr) p_ccommand->vRunCommand();
	else cout << "pusta komenda" << endl;
}

string CMenuCommand::sget_name()
{
	return s_name;
}//string CMenuCommand::sget_name()

string CMenuCommand::sget_command()
{
	return s_command;
}//string CMenuCommanSd::sget_command()
