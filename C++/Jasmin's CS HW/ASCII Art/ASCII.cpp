//============================================================================
// Name        : ASCII.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
	string input = "";
	string sub = "";
	string output = "";
	string line = "";
	int subCounter = 0;
	int subLength = 0;
	int found = 0;

	cout << "What is the template file name?" << endl;
	getline(cin, input);
	cout << "What is the substitution string?" << endl;
	getline(cin, sub);
	cout << "What is the output file name?" << endl;
	getline(cin, output);

	subLength = sub.length();

	ofstream outfile;
	outfile.open(output.c_str());
	ifstream infile;
	infile.open(input.c_str());
	if (infile.is_open()) {
		while (getline(infile, line)) {
			subCounter = 0;
			found = line.find_first_of("*");
			while (found != line.npos) {
				line[found] = sub[subCounter];
				found = line.find_first_of("*", found + 1);
				subCounter++;
				if (subCounter == subLength) {
					subCounter = 0;
				}
			}
			outfile << line << "\n";
		}
		infile.close();
		outfile.close();
	}

	else {
		cout << "Unable to open file" << endl;
	}



	return 0;
}
