
// Zad.2_ZMPO.cpp : Ten plik zawiera funkcję „main”. W nim rozpoczyna się i kończy wykonywanie programu.
//

#include "pch.h"
#include <iostream>
#include "CMenu.h"
#include "CMenuCommand.h"
#include "CCommand.h"
#include "CCreateCTable.h"
#include "CSetSizeCTable.h"
#include "CDeleteCTable.h"
#include "CDeleteAll.h"
#include "CChangeName.h"
#include "CChangeCTable.h"
#include "CCopyCTable.h"
#include "CShowAll.h"
#include "CBoolKnapsack.h"
#include "CIntKnapsack.h"
#include "CDoubleKnapsack.h"
#include "CCreateKnapsack.h"
#include "CPrintAla.h"

int main()
{
	CMenu *p_main_menu = new CMenu("Main menu", "main");
	CMenu *p_podmenu1 = new CMenu("Podmenu1", "menu1");
	CMenu *p_podmenu2 = new CMenu("Podmenu2", "menu2");
	CMenu *p_podmenu3 = new CMenu("Podmenu3", "menu3");
	//CMenu *p_podmenu4 = new CMenu("Podmenu3", "menu4");
	CMenu *p_podmenu5 = new CMenu("CTable", "ctable");
	CMenu *p_podmenu6 = new CMenu("KnapsackProblem", "knapsack");
	CMenu *p_podpodmenu11 = new CMenu("PodPodMenu1", "menu11");
	CMenu *p_podpodmenu12 = new CMenu("PodPodMenu2", "menu12");
	CMenu *p_podpodmenu21 = new CMenu("PodPodMenu1", "menu21");
	CMenu *p_podpodmenu31 = new CMenu("PodPodMenu1", "menu31");
	p_main_menu->vadd_item(p_podmenu5);

	CCreateCTable *p_ccreate = new CCreateCTable();
	CMenuCommand *p_ccommand1 = new CMenuCommand(p_ccreate);
	
	CSetSizeCTable *p_set_size = new CSetSizeCTable(p_ccreate);
	CMenuCommand *p_ccommand2 = new CMenuCommand(p_set_size);

	CDeleteCTable *p_del_ctable = new CDeleteCTable(p_ccreate);
	CMenuCommand *p_ccommand3 = new CMenuCommand(p_del_ctable);

	CDeleteAll *p_del_all = new CDeleteAll(p_ccreate);
	CMenuCommand *p_ccommand4 = new CMenuCommand(p_del_all);

	CChangeName *p_change_name = new CChangeName(p_ccreate);
	CMenuCommand *p_ccommand5 = new CMenuCommand(p_change_name);

	CChangeCTable *p_change_ctable = new CChangeCTable(p_ccreate);
	CMenuCommand *p_ccommand6 = new CMenuCommand(p_change_ctable);

	CCopyCTable *p_copy_ctable = new CCopyCTable(p_ccreate);
	CMenuCommand *p_ccommand7 = new CMenuCommand(p_copy_ctable);

	CShowAll *p_show_ctable = new CShowAll(p_ccreate);
	CMenuCommand *p_ccommand8 = new CMenuCommand(p_show_ctable);

	p_podmenu5->vadd_item(p_ccommand1);
	p_podmenu5->vadd_item(p_ccommand2);
	p_podmenu5->vadd_item(p_ccommand3);
	p_podmenu5->vadd_item(p_ccommand4);
	p_podmenu5->vadd_item(p_ccommand5);
	p_podmenu5->vadd_item(p_ccommand6);
	p_podmenu5->vadd_item(p_ccommand7);
	p_podmenu5->vadd_item(p_ccommand8);


	CBoolKnapsack *p_bool_knap = new CBoolKnapsack();
	CMenuCommand *p_ccommand9 = new CMenuCommand(p_bool_knap);

	CIntKnapsack *p_int_knap = new CIntKnapsack();
	CMenuCommand *p_ccommand10 = new CMenuCommand(p_int_knap);

	CDoubleKnapsack *p_double_knap = new CDoubleKnapsack();
	CMenuCommand *p_ccommand11 = new CMenuCommand(p_double_knap);

	p_podmenu6->vadd_item(p_ccommand9);
	p_podmenu6->vadd_item(p_ccommand10);
	p_podmenu6->vadd_item(p_ccommand11);

	CPrintAla *p_print_ala = new CPrintAla();
	CMenuCommand *p_ccommand = new CMenuCommand(p_print_ala);

	p_main_menu->vadd_item(p_ccommand);
	p_main_menu->vadd_item(p_podmenu1);
	p_main_menu->vadd_item(p_podmenu2);
	p_main_menu->vadd_item(p_podmenu3);
	//p_main_menu->vadd_item(p_podmenu4);
	p_main_menu->vadd_item(p_podmenu6);
	p_podmenu1->vadd_item(p_podpodmenu11);
	p_podmenu1->vadd_item(p_podpodmenu12);
	p_podmenu2->vadd_item(p_podpodmenu21);
	p_podmenu3->vadd_item(p_podpodmenu31);
	p_main_menu->vRun();

	delete p_main_menu;
	system("pause");
}

// Uruchomienie programu: Ctrl + F5 lub menu Debugowanie > Uruchom bez debugowania
// Debugowanie programu: F5 lub menu Debugowanie > Rozpocznij debugowanie

// Porady dotyczące rozpoczynania pracy:
//   1. Użyj okna Eksploratora rozwiązań, aby dodać pliki i zarządzać nimi
//   2. Użyj okna programu Team Explorer, aby nawiązać połączenie z kontrolą źródła
//   3. Użyj okna Dane wyjściowe, aby sprawdzić dane wyjściowe kompilacji i inne komunikaty
//   4. Użyj okna Lista błędów, aby zobaczyć błędy
//   5. Wybierz pozycję Projekt > Dodaj nowy element, aby utworzyć nowe pliki kodu, lub wybierz pozycję Projekt > Dodaj istniejący element, aby dodać istniejące pliku kodu do projektu
//   6. Aby w przyszłości ponownie otworzyć ten projekt, przejdź do pozycji Plik > Otwórz > Projekt i wybierz plik sln
