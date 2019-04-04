#include "pch.h"
#include "CInterface.h"


CInterface::CInterface()
{
}


CInterface::~CInterface()
{
	for (int i = 0; i < c_vec.size(); i++)
	{
		delete c_vec[i];
	}
}

void CInterface::vRun()
{
	int i_choice;
	int i_num;

	do
	{
		cout << "\nOptions: \n";
		cout << "[1]Create CTables\n";
		cout << "[2]Change size of CTable\n";
		cout << "[3]Delete a CTable\n";
		cout << "[4]Delete all CTables\n";
		cout << "[5]Change name of CTable\n";
		cout << "[6]Clone a CTable\n";
		cout << "[7]Show a CTable\n";
		cout << "[8]Change one value of CTable\n";
		cout << "[9]Show all CTables\n";
		cout << "[10]Exit\n\n";
		cout << "Decision: ";

		cin >> i_choice;
		if (cin.good())
		{
			switch (i_choice)
			{
			case 1:

				system("cls");

				cout << "How many CTables do you want to create?";
				cin >> i_num;

				if (i_num > 0)
				{
					for (int i = 0; i < i_num; i++)
					{
						CTable *pc_table = new CTable();
						c_vec.push_back(pc_table);
					}
				}
				else
					cout << "Uncorrect number!";
				break;

			case 2:

				system("cls");

				cout << "Which CTable's size do you want to change?";
				cin >> i_num;

				if (i_num >= 0 && i_num < c_vec.size())
				{
					int i_size;
					cout << "\nWhat will be the size?";
					cin >> i_size;
					if (c_vec[i_num]->bSetSize(i_size))
						cout << "\nDone!";
					else
						cout << "Uncorrect size!";
				}
				else
					cout << "Uncorrect number!";
				break;

			case 3:

				system("cls");

				cout << "Which CTable do you want to delete?";
				cin >> i_num;

				if (i_num >= 0 && c_vec.size())
				{
					delete c_vec[i_num];
					c_vec.erase(c_vec.begin() + i_num);
				}
				else
					cout << "Uncorrect number!";
				break;

			case 4:

				for (int i = 0; i < c_vec.size(); i++)
				{
					delete c_vec[i];
				}

				c_vec.clear();
				break;

			case 5:

				system("cls");

				cout << "Which CTable's name do you want to change?";
				cin >> i_num;

				if (i_num >= 0 && c_vec.size())
				{
					string s_string;

					cout << "\nWhat would be the new name?";
					cin >> s_string;

					c_vec[i_num]->vSetName(s_string);
				}
				else
					cout << "Uncorrect number!";
				break;

			case 6:

				system("cls");

				cout << "Which CTable do you want to copy?";
				cin >> i_num;

				if (i_num >= 0 && c_vec.size())
				{
					CTable *pc_table = new CTable(*c_vec[i_num]);
					c_vec.push_back(pc_table);
				}
				else
					cout << "Uncorrect number!";
				break;

			case 7:

				system("cls");

				cout << "Which CTable do you want to show?";
				cin >> i_num;

				if (i_num >= 0 && c_vec.size())
				{
					cout << endl << c_vec[i_num]->toString();
				}
				else
					cout << "Uncorrect number!";
				break;

			case 8:

				system("cls");

				cout << "Which CTable do you want to change?";
				cin >> i_num;

				if (i_num >= 0 && c_vec.size())
				{
					int i_pos;
					int i_value;
					cout << "\nWhat would be the position of the new value?";
					cin >> i_pos;

					cout << "\nWhat would be the new value?";
					cin >> i_value;

					if (c_vec[i_num]->bAdd(i_pos, i_value))
						cout << "\nDone!";
					else
						cout << "\nWrong position!";
				}
				else
					cout << "Uncorrect number!";
				break;

			case 9:

				system("cls");

				for (int i = 0; i < c_vec.size(); i++)
				{
					cout << endl << c_vec[i]->toString();
				}

				break;

			default:
				break;
			}
		}
		else
		{
		cout << endl << "Bledne dane, sprobuj ponownie.";
			cin.clear();
			cin.ignore();
		}
	} while (i_choice != 10);
}