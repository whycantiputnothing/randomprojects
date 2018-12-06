#include <iostream>
using namespace std;

int evens(int n) {
	int sum = 0;
	for (int i = 2; i <= 2*n; i += 2) {
		sum += i;
	}
	return sum;
}
int main() {
	cout << evens(3);
	return 0;
}
