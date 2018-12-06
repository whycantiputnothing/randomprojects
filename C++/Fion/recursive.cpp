#include <iostream>

using namespace std;

int recurse(int n) {
	if (n == 1)
		return 3;
	else
		return recurse(n - 1) * 2 + 5;
}
int main() {
	int element;
	cout << "Which element of the sequence would you like to know?" << endl;
	cin >> element;
	cout << recurse(element);
	return 0;
}
