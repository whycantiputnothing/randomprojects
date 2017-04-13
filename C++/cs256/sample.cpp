#include <iostream>
using namespace std;

int main () {
	int x = 5;
	const int * const pint = &x;

	cout << "*pint: " << *pint << endl;
	cout << "pint: " << pint << endl;
	cout << "x: " << x << endl;
	x = 10;     // But we can change x!
	cout << "x: " << x << endl;
	cout << "*pint: " << *pint << endl;
	return 0;
}
