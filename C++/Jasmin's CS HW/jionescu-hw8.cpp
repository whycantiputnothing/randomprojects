//
// Name: 		Ionescu, Jasmin
// Due:		 	March 4, 2016
// Course:		cs-128-02-w16
//
// Description:
//				Using arrays, prompt the user for 10 integer numbers and ouput them in reverse order.
//

#include <iostream>
using namespace std;



int main ()
{
	int foo [10];
	for (int i=0 ; i<10 ; ++i )
	{
		cout << "NUMBERS by Jasmin Ionescu" << endl;

	  if (i == 0)
		  cout <<"please enter the 1st integer: ";
	  else if (i == 1)
		  cout <<"please enter the 2nd integer: ";
	  else
    	cout << "please enter the " << i + 1 << "th integer: ";
	  cin >> foo[9-i];
	}
	for (int i = 0 ; i < 10; ++i)
	{
		cout << foo[i] << endl;
	}
  return 0;
}