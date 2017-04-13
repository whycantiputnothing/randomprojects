#include <iostream>
using namespace std;

int main(){	
	char ESC = 27;
	cout << ESC << "[2J" << ESC << "[13;35f" << flush;
	cout << "hello world";
	cout << ESC << "[0;80f";
	return 0;
}
