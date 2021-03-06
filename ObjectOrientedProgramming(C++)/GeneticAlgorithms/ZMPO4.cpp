// ZMPO4.cpp : Ten plik zawiera funkcję „main”. W nim rozpoczyna się i kończy wykonywanie programu.
//

#include "pch.h"
#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
#include "CGeneticAlgorithm.h"
#include "CIndividual.h"

using namespace std;

int main()
{
	/*int i_value_table[10] = { 5,1,4,3,5,8,9,10,11,1};
	int i_weight_table[10] = { 4,1,3,2,4,5,6,7,8,1};
	int i_weight = 12;
	int i_size = 10;*/

	int i_value_table[7] = { 1,7,5,7,2,5,3 };
	int i_weight_table[7] = { 2,5,3,6,2,4,4 };
	int i_weight = 15;
	int i_size = 7;

	/*int *pi_value_table = new int[10]; 
	pi_value_table[0] = 5; pi_value_table[1]  = 1; pi_value_table[2] = 4; pi_value_table[3] = 3; pi_value_table[4] = 5;
	pi_value_table[5] = 8; pi_value_table[6] = 9; pi_value_table[7] = 10; pi_value_table[8] = 11; pi_value_table[9] = 1;
	
	int *pi_weight_table = new int[10]; 
	pi_weight_table[0] = 4; pi_weight_table[1] = 1; pi_weight_table[2] = 3; pi_weight_table[3] = 2; pi_weight_table[4] = 4;
	pi_weight_table[5] = 5; pi_weight_table[6] = 6; pi_weight_table[7] = 7; pi_weight_table[8] = 8; pi_weight_table[9] = 1;
	pi_weight_table = &pi_weight_table[0];
	int i_weight = 12;
	int i_size = 10;*/

	srand(time(NULL));
	
	CKnapsackProblem<bool> *myknap = new CKnapsackProblem<bool>(i_weight_table, i_value_table, i_weight, i_size);
	CGeneticAlgorithm<bool> mygen(*myknap);
	mygen.vRun();

	/*CKnapsackProblem<int> *myknap = new CKnapsackProblem<int>(i_weight_table, i_value_table, i_weight, i_size);
	CGeneticAlgorithm<int> mygen(*myknap);
	mygen.vRun();*/

	/*CKnapsackProblem<double> *myknap = new CKnapsackProblem<double>(i_weight_table, i_value_table, i_weight, i_size);
	CGeneticAlgorithm<double> mygen(*myknap);
	mygen.vRun();*/

	cout << endl << endl << "Best solution is:" << mygen.getBestSolution().toString() << " Result: " << mygen.getBestFittness() << endl;
	
	return 0;
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
