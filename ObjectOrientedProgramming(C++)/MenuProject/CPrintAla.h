#pragma once
#ifndef CPrintAla_h
#define CPrintAla_h
#include "CCommand.h"


class CPrintAla: public CCommand
{
public:
	CPrintAla();
	~CPrintAla();
	void vRunCommand();
};
#endif
