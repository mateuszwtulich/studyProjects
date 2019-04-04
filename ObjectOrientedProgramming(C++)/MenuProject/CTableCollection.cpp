#include "pch.h"
#include "CTableCollection.h"


CTableCollection::CTableCollection()
{
}


CTableCollection::~CTableCollection()
{
}

vector<CTable *> CTableCollection::getVector()
{
	return vec_collection;
}

void CTableCollection::v_addCTable(CTable* cTable)
{
	vec_collection.push_back(cTable);
}

void CTableCollection::v_deleteCTable()
{

}

int CTableCollection::i_size() {
	return vec_collection.size();
}
