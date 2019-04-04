#include "pch.h"
#include "CPrintAla.h"


CPrintAla::CPrintAla()
{
	s_name = "Print Ala";
	s_command = "ala";
}

CPrintAla::~CPrintAla()
{
	cout << "usuwam: " << s_name << endl;
}

void CPrintAla::vRunCommand()
{
	cout << "Ala ma kota" << endl << endl;
}