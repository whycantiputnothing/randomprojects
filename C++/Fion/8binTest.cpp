#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int binConv(string n) {
	int answer = 0;
	for (int i = 7; i >= 0; i--) {
		answer += (n[i] - '0') * pow(2.0, double(7 - i));
	}
	return answer;
}

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
int main() {
	string str;
	for (int i = 0; i < pow(2, 8); i++) {
		str = decToBin(i, 8);
		cout << "The binary number " << str << " is decimal number " << binConv(str) << endl;
	}
	return 0;
}
