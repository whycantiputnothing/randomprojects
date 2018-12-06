#include <iostream>

using namespace std;

int functArr(int arr[]){
	return arr[1];
}

int abc(int *arr){
	return *arr;
}

int main() {
	int p[5];
	p[1] = 5;
	cout << functArr(p) << endl;
	cout << abc(p) << endl;


	return 0;
}
