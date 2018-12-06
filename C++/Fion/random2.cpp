#include <iostream>
#include <string>
using namespace std;

string make_message1(string msg);
int number_calculator(int &a, int b);

int main()
{
	int x(9), y(5);
	string m = "Hello!";

	int z = number_calculator(x, y);
	string msg = make_message1(m);

	return 0;
}

string make_message1(string msg) {
	return msg;
}
//			Precondition: n	> 1.
//                      n = number of elements in array x
//          Postcondition: standard deviation is written to standard output
//          with 3 decimal places

int number_calculator(int &a, int b){
	return 0;
}
