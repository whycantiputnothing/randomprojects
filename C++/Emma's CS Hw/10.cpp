#include <iostream>
using namespace std;

const int ARRAY_SIZE = 1000;
int foo[ARRAY_SIZE];

void print(int j) {
	cout << "You entered:" << endl;
	for (int i = 0; i < j - 1; i++) {
		cout << foo[i] << " ";
	}
}

bool isInTheArray(int i) {
	for (int j = 0; j < ARRAY_SIZE; j++) {
		if(foo[j] == i)
			return true;
	}
	return false;
}

void UI() {
	int i = 0;
	int counter = 0;
	while (i >= 0) {
		cout << "Enter a non-negative integer (negative to quit): " ;
		cin >> i;
		if(!isInTheArray(i)) {
			foo[counter] = i;
			counter++;
		}
	}
	print(counter);
}
int main () {
	UI();
	return 0;
}
