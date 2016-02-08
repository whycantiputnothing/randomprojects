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
	int randNum = rand() % 100 + 1;
	int guess = 0;
	int counter = 1;

	while (counter < 9) {
		cout << "Please enter your guess?" << endl;
		cin >> guess;
		if (guess == 0) {
			cout << "The secret number is " << randNum << "." << endl;
			return 0;
		}
		else if(guess > 100 || guess < 1 ){
			cout << "Invalid input" << endl;
			counter--;
		}
		else if(guess > randNum) {
			cout << "Guess is high..." << endl;

		}
		else if(guess < randNum) {
			cout << "Guess is low..." << endl;
		}
		else {
			cout << "Correct in " << counter << " guesses" << endl;
			return 0;
		}
		counter++;
	}
	cout << "Too man guesses, the secret number is " << randNum << "." << endl;

	return 0;
}
