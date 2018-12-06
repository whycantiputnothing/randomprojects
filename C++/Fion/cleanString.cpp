#include <string>
#include <iostream>

using namespace std;

// Pre-Condition: Takes a string s as argument.
// Post-Condition: Returns a boolean value, TRUE, if the string represents a palindrome, or FALSE, if otherwise.
static bool isPalindrome(string s)
{
	if (s.length()==0 || s.length()==1)
		return true;
	if (s.at(0) == s.at(s.length()-1))
		return isPalindrome(s.substr(1, s.length()-2));
	return false;
}

// Pre-Condition: Takes a string s as argument, which may contain ANY character, including spaces, etc...
// Post-Condition1: Changes the string argument (s) by removing all non-alphanumeric characters from it.
// Post-Condition2: Changes the string argument (s) by making all characters of the same case.
static void cleanUp(string &s)
{
	string newStr = "";

	for (int i = 0; i < s.size(); i++) //loop go through string
	{
		if(isalpha (s[i])) //if its not an alphabet
		{
			if(isupper(s[i])) //if character is uppercase
				newStr += tolower(s[i]); //change it to lower
			else
				newStr += s[i];

		}
	}
	s = newStr;
}

int main() {
	string str1 = "Pls clean this up :2123 [] asdf";
	cleanUp(str1);
	cout << str1;
	return 0;
}
