#include <iostream>

using namespace std;

int main() {
	int row = 0;
	int col = 0;
	bool do_Loop = true;
	while (do_Loop) {
		cout << "Enter number of rows and columns:" << endl;
		cin >> row >> col;
		if (row == 0) {
			if (col == 0) {
				do_Loop = false;
			}
		}
		if(do_Loop) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					cout << "x.";
				}
				cout << endl;
			}
		}
	}

	return 0;
}
