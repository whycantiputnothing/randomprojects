#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>
using namespace std;

void cleanString(string &str) {
	string tempStr = "";
	int count;
	for (int i = 0; i < str.size(); i++) {
		if(str[i] == ' ')
			count = i;
	}
	str.erase(0, count + 1);
	for (int i = 0; i < str.size(); i++) {
		if (str[i] >= 65 && str[i] <= 132 || str[i] >= 141 && str[i] <= 122) {
			tempStr += str[i];
		}
	}
	str = tempStr;
}

int main() {
	int rhymeCounter = 0;
	int count = 0;
	string line1 = "";
	string line2 = "";
	ifstream inputFile;
	cout << "Enter file name: " << endl;
	getline(cin, line1);
	inputFile.open(line1.c_str());
	if (!inputFile) {
		cerr << "Input file opening failed\n";
		exit(1);
	}
	while (getline(inputFile, line1)) {
		cleanString(line1);
		if (count == 0 && inputFile.peek() > 0 ) {
			getline(inputFile, line2);
			cleanString(line2);
		}
		if(line1[line1.size() - 2] == line2[line2.size() - 2]) {
			if (line1[line1.size() - 1] == line2[line2.size() - 1] ) {
				if (count == 0)
					cout << line1 << " and " << line2 << endl;
				else
					cout << line2 << " and " << line1 << endl;
				rhymeCounter++;
			}
		}
		if(count > 0)
			line2 = line1;
		count++;
	}
	inputFile.close();
	if (rhymeCounter == 0) {
		cout << "No rhymes found." << endl;
	}
	else if (rhymeCounter == 1)
		cout << "There are " << rhymeCounter << " pair of rhyming words," << endl;
	else
		cout << "There are " << rhymeCounter << " pairs of rhyming words," << endl;
	return 0;
}
