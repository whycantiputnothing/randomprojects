#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int terms = 0;
	double pivalue = 1.0;

	cout << "Enter the number of terms to approximate (or zero to quit):" << endl;
	cin >> terms;
	for(int i = 1; i <= terms; i++) {
		if(i % 2 == 1) {
			pivalue = pivalue - (1.0)/(i*2+1);
		}
		else {
			pivalue = pivalue + (1.0)/(i*2+1);
		}
	}
	pivalue = pivalue*4;
	cout << pivalue;
	return 0;
}
