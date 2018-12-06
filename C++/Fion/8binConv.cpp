#include <cstring>
#include <cmath>
#include <iostream>

using namespace std;

int main(int argc, char *argv[]) {
	int answer = 0;
	if (argc != 2)
		cerr << "Usage: 8binConv <8-bit binary number> " << endl;
	else if(strlen(argv[1]) != 8 ) {
		cerr <<  "Usage: 8binConv <8-bit binary number> " << endl;
	}
	else {
		for (int i = 7; i >= 0; i--) {
			answer += (argv[1][i] - '0') * pow(2, 7 - i);
		}
		cout << "That's " << answer << " in decimal." << endl;
	}
	return 0;
}
