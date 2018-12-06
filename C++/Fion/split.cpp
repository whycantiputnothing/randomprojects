#include <iostream>
#include <string>
#include <vector>

using namespace std;


vector<string> split(string target, string delimiter)
//function to split the strings
{
	int pos = 0;
	vector<string> split_string; //initialize vector
	string tempstring= ""; //initialize string
	while ((pos = target.find(delimiter)) != string::npos) {
		tempstring = target.substr(0, pos);
		split_string.push_back(tempstring);
		target.erase(0, pos + delimiter.size());
	}
	if (target.size() > 0) {
		split_string.push_back(target);
	}
	return split_string;
}

int main()
{
	// Declare our variables
	string input, delimiter; //initialize variables
	vector<string> split_string; //initialize vector
	cout << "Enter string to split:" << endl;
	getline(cin,input); //get input
	cout << "Enter delimiter string:" << endl;
	getline(cin,delimiter); //get delimiter
	split_string = split(input, delimiter); //utilizes function to split input
	cout << "The substrings are: ";
	for (int i = 0; i < split_string.size(); i++)
	//for loop to print sorted vector with " " and commas in between
	{
		cout << '"' << split_string[i] << '"';
		if (i < split_string.size()-1)
		{
			cout << ", ";
		}
	}
	cout <<endl;
}
