#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int terms = 0;
	double pivalue = 0.0;
	int isTrue = 1;
	while (isTrue) {
		cout << "Enter the number of terms to approximate (or zero to quit):" << endl;
		cin >> terms;
		if (terms == 0) {
			isTrue = 0;
		}
		if (isTrue) {
			for(int i = 0; i < terms + 1; i++) {
				pivalue += (pow(-1,i) * (1.0 / (2 * i + 1)));
			}
			pivalue = pivalue*4;
			cout << pivalue << endl;
			pivalue = 0.0;
		}

	}

	return 0;
}
