#include "stdafx.h"
#include <cstring>
#include "stdio.h"
#include <conio.h>
#include <iostream>
#include <string>
#include "string.h"
#include <sstream>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

using namespace std;



int getDigitFromChar(const char ch) {

	switch (ch) {
	case 'A':
		return 0;
	case 'B':
		return 1;
	case 'C':
		return 2;
	case 'D':
		return 3;
	case 'E':
		return 4;
	case 'F':
		return 5;
	case 'G':
		return 6;
	case 'H':
		return 7;
	case 'J':
		return 8;
	case 'K':
		return 9;

	default:
		return -1;

	}
}


int main()
{
	int rows = 0;
	string inputSeats;
	cin >> rows;
	//std::getline(cin, inputSeats);
	std::cin >> inputSeats;
	//cin.getline(inputSeats, 1000);

	//string xyz = "ABCHD EFGH IGKL MNOP QRST UVWX YZ";
	const char* strdata = inputSeats.c_str();

	for (int i = 0; i < inputSeats.size(); ++i)
		cout << strdata[i];
	cout << "==> \n";

	int** flight = new int*[rows];
	for (int i = 0; i < rows; ++i)
		flight[i] = new int[10];

	for (int i = 0; i<rows; i++)
	{
		for (int j = 0; j<10; j++)
		{
			flight[i][j] = 0;
		}
	}


	int number = 0;
	int seat = 0;
	for (int i = 0; i < inputSeats.length(); i++) {
		cout << strdata[i];
		if (isdigit(strdata[i])) {
			if (isdigit(strdata[i + 1])) {
				number = (int(strdata[i]) - 48) * 10 + (int(strdata[i + 1]) - 48);
				seat = getDigitFromChar(strdata[i + 2]);
				i += 2;
				flight[number - 1][seat] = 1;
			}
			else {
				number = int(strdata[i]) - 48;
				seat = getDigitFromChar(strdata[i + 1]);
				i += 1;
				flight[number - 1][seat] = 1;
			}
			cout << endl;
		}
	}

	//string seats = "1A3C2B40G5A";
	// ABC - 012
	// DEF - 345
	// EFG - 456
	// HJK - 789
	int totalSeatsAvailable = 0;
	for (int i = 0; i<rows; i++)
	{
		//Case ABC
		if (flight[i][0] == 0 && flight[i][1] == 0 && flight[i][2] == 0) {
			totalSeatsAvailable += 1;
		}

		//Case DEF AND EFG
		if (
			(flight[i][3] == 0 && flight[i][4] == 0 && flight[i][5] == 0) ||
			(flight[i][4] == 0 && flight[i][5] == 0 && flight[i][6] == 0)
			)
		{
			totalSeatsAvailable += 1;
		}

		//Case HJK
		if (flight[i][7] == 0 && flight[i][8] == 0 && flight[i][9] == 0) {
			totalSeatsAvailable += 1;
		}

	}


	cout << "\nThe total Seats available are: " << totalSeatsAvailable;
	//cout << endl << "lool" << endl;

	cout << " Pringting the Array!! " << endl;
	for (int i = 0; i<rows; i++)
	{
		for (int j = 0; j<10; j++)
		{
			cout << flight[i][j] << "\t";
		}
		cout << endl;
	}


	_getch();
	return 0;
}