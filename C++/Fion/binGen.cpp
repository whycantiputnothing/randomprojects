#include <iostream>
#include <string>
#include <cmath>
using namespace std;

string decToBin(int d, int n) {
	int counter = 0;
	string temp;
	for (int i = 0; i < n; i++) {
		temp += '0';
	}
	do {
		temp[n - counter - 1] = d % 2 + '0';
		d = d / 2;
		counter++;
		if (d == 1) {
			temp[n - counter - 1] = d % 2 + '0';
		}
	} while (d / 2 > 0);
	return temp;
}

int main () {
	int n = 0;
	cout << "How many bits to generate? ";
	cin >> n;
	for (int i = 0; i < pow(2, n); i++) {
		cout << "The decimal number " << i << " is " << decToBin(i, n) << endl;
	}

	return 0;
}
