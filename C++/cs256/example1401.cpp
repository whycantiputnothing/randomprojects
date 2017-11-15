#include <iostream>
using namespace std;

long* fill(int);
long* reverse(long*, int);
void print(long*, int);

int main() {
	long *list;
	long *revlist;

	list = fill(100);
	revlist = reverse(list, 100);
// print(list, 100);

	return 0;
}

long* fill(int n) {
	long* list = new long[n];
	list[0] = 0;
	if (n > 2)
		list[1] = 1;

	for (int i = 2; i < n; i++) {
		list[i] = list[i-1] + list[i-2];
	}

	return list;

}

long* reverse(long *list, int n) {
	long *reverse = new long[n];
	for (int i = 0; i < n; i++) {
		reverse[i] = list[n-i-1];
	}

	return reverse;
}

void print(long *list, int n){
	for (int i = 0; i < n; i++) {
		cout << "#" << i + 1 << ": " << list[i] << endl;
	}

}
