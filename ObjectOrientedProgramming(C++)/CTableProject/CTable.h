#pragma once

#include <string>
#include <iostream>
#define DEFAULT_COUNTER 0
#define DEFAULT_CTABLE_NAME "Default_"
#define DEFAULT_CTABLE_SIZE 10
#define BEZPARAMETRU "bezp: '"
#define PARAMETR "parametr: "
#define END_LINE "'\n"
#define COPY "_copy"
#define KOPIUJ "kopiuj: '"
#define DESTRUCTOR  "usuwam: "
using namespace std;

class CTable
{
public:
	CTable();
	CTable(string sName, int iSize);
	CTable(CTable &pcOther);
	~CTable();
	string sGetName();
	void vSetName(string sName);
	bool bSetSize(int iSize);
	bool bAdd(int &iPos, int &iVal);
	int iGet(int &iPos, int *piSucc);
	void cCopy(CTable &pcOther);
	string toString();

private:
	string s_name;
	int i_size;
	int *pi_ctable;
};

