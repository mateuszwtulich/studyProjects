#include "pch.h"
#include "CMenu.h"
//#include "CMenuCommand.h"


CMenu::CMenu()
{
	s_name = "Default name";
	s_command = "default";
}//CMenu::CMenu()

CMenu::CMenu(string sName, string sCommand) 
{
	s_name = sName;
	s_command = sCommand;
}//CMenu::CMenu(string sName, string sCommand)

CMenu::~CMenu() 
{
	for (int i = 0; i < cmenu_item_vector.size(); i++)
	{
		delete cmenu_item_vector[i];
	}
	cout << "usuwam: " << s_name << endl;
}

void CMenu::vinitialize() {
}

void CMenu::vRun() {
	string s_new_command;
	do
	{
		cout << endl << sget_name() << ": " << endl<< endl;

		for (int i = 0; i < cmenu_item_vector.size(); i++)
		{
			cout << i+1 << ". " << cmenu_item_vector[ i ]->sget_name()  << "(" << cmenu_item_vector[ i ]->sget_command() << ")" << endl;
		}//for (int i = 0; i < cmenu_item_vector.size(); i++)

		cout << cmenu_item_vector.size()+1 << ". " << "Back(back)" << endl;

		cin >> s_new_command;
		system("cls");

		int i_counter = 0;

		for (int i = 0; i < cmenu_item_vector.size(); i++)
		{
			if (s_new_command == cmenu_item_vector[i]->sget_command())
			{
					i_counter++;
					cmenu_item_vector[i]->vRun();
			}
		}//for (int i = 0; i < cmenu_item_vector.size(); i++)

		if (i_counter == 0 && s_new_command != "back") cout << "Nie ma takiej komendy. Spróbuj ponownie\n";
		
	} while (s_new_command != "back");

}//void CMenu::vRun() 

void CMenu::del() {
	for (int i = 0; i < cmenu_item_vector.size(); i++) 
	{
		delete cmenu_item_vector[i];
	}//for (int i = 0; i < cmenu_item_vector.size(); i++) 
}//void CMenu::del() 


void CMenu::vadd_item(CMenuItem *cmenu_item)
{
	int i_counter = 0;
	for (int i = 0; i < cmenu_item_vector.size(); i++)
	{
		if (cmenu_item->sget_name() == cmenu_item_vector[i]->sget_name() || cmenu_item->sget_command() == cmenu_item_vector[i]->sget_command()) i_counter++;
	}
	if (i_counter == 0) 
	{
		cmenu_item_vector.push_back(cmenu_item);
	}
	else
	{
		cout << "Funkcjonalnosc: [" << cmenu_item->sget_name() << " " << cmenu_item->sget_command() << "] wiec nie zostala dodana." <<  endl << endl;
	}
}//void CMenu::vadd_item(CMenuItem* cmenu_item)

string CMenu::sget_name() 
{
	return s_name;
}//string CMenu::sget_name()

string CMenu::sget_command() 
{
	return s_command;
}//string CMenu::sget_command()