#pragma once
#ifndef CMenuItem_h
#define CMenuItem_h
#include <iostream>
#include <string>
using namespace std;

class CMenuItem
{
public:
	virtual ~CMenuItem();
	virtual void vRun()=0;
	virtual string sget_name() = 0;
	virtual string sget_command() = 0;

protected:
	string s_command;
	string s_name;
};
#endif


