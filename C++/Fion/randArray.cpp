#include <ctime>
#include <cstdlib>
#include <iostream>

using namespace std;

int main() {
	srand (time(0));
	int myArr[10][5];
	int find = 0;
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 5; j++) {
			myArr[i][j] = rand() % 49;
		}
	}
	cout << "What number between 0 and 49 would you like to find?" << endl;
	cin >> find;
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 5; j++) {
			if(myArr[i][j] == find) {
				cout << "Row: " << i << " Col: " << j << endl;
				return 0;
			}
		}
	}
	cout << "I did not find this number." << endl;
	return 0;
}
