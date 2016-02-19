//============================================================================
// Name        : Jasmin.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main() {

	srand(time( NULL ));
	int die1 = 0;
	int die2 = 0;
	int numberOfRolls = 0;
	int counter = 0;
	cout << "what is the number of rolls?" << endl;
	cin >> numberOfRolls;
	while (counter < numberOfRolls) {
		die1 = rand() % 6 + 1;
		die2 = rand() % 6 + 1;
		cout << die1 << " " << die2 << endl;
		switch(die1) {
		case 1 :
			switch(die2) {
			case 1:
				cout << "Snake Eyes" << endl;
				break;
			case 2:
				cout << "Ace Duece" << endl;
				break;
			case 3 :
				cout << "Easy Four" << endl;
				break;
			case 4 :
				cout << "Five" << endl;
				break;
			case 5 :
				cout << "Easy Six" << endl;
				break;
			case 6 :
				cout << "Natural" << endl;
				break;
			}
			break;
		case 2 :
			switch (die2) {
			case 1:
				cout << "Ace Duece" << endl;
				break;
			case 2 :
				cout << "Hard Four" << endl;
				break;
			case 3 :
				cout << "Five" << endl;
				break;
			case 4:
				cout << "Easy Six" << endl;
				break;
			case 5:
				cout << "Natural" << endl;
				break;
			case 6:
				cout << "Easy Eight" << endl;
				break;
			}
			break;
		case 3 :
			switch (die2) {
			case 1:
				cout << "Easy Four" << endl;
				break;
			case 2 :
				cout << "Five" << endl;
				break;
			case 3 :
				cout << "Hard Six" << endl;
				break;
			case 4:
				cout << "Natural" << endl;
				break;
			case 5:
				cout << "Easy Eight" << endl;
				break;
			case 6:
				cout << "Nine" << endl;
				break;
			}
			break;
		case 4 :
			switch (die2) {
			case 1:
				cout << "Five" << endl;
				break;
			case 2 :
				cout << "Easy Six" << endl;
				break;
			case 3 :
				cout << "Natural" << endl;
				break;
			case 4:
				cout << "Hard Eight" << endl;
				break;
			case 5:
				cout << "Nine" << endl;
				break;
			case 6:
				cout << "Easy Ten" << endl;
				break;
			}
			break;
		case 5 :
			switch (die2) {
			case 1:
				cout << "Easy Six" << endl;
				break;
			case 2 :
				cout << "Natural" << endl;
				break;
			case 3 :
				cout << "Easy Eight" << endl;
				break;
			case 4:
				cout << "Nine" << endl;
				break;
			case 5:
				cout << "Hard Ten" << endl;
				break;
			case 6:
				cout << "Yo" << endl;
				break;
			}
			break;
		case 6 :
			switch (die2) {
			case 1:
				cout << "Natural" << endl;
				break;
			case 2 :
				cout << "Easy Eight" << endl;
				break;
			case 3 :
				cout << "Nine" << endl;
				break;
			case 4:
				cout << "Easy Ten" << endl;
				break;
			case 5:
				cout << "Yo" << endl;
				break;
			case 6:
				cout << "Boxcars" << endl;
				break;
			}
			break;
		}
		counter++;
	}

	return 0;
}
