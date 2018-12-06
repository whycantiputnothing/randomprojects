#include <iostream>
using namespace std;
//function declaration
void compute_coins(int coin_value, int& num, int& amount_left);


int main()
{
	bool repeat = true;
	bool validInput = false;
	int amount_left=-1;
	int num;
	//repeat a loop until repeat is true
	while(repeat)
	{
		//run a loop until valid amount is entered, accept numbers between 1 and 100
		do
		{
			cout<< "Enter number of cents (or zero to quit): "<<endl;
			cin>> amount_left;
			//if the amount entered is out of range print an error message and prompt again
			if(amount_left < 0 || amount_left >= 100)
			{
				cout<< "Enter a number between 1 and 99..."<<endl;
			}
			else
			{
				validInput = true;
			}
		}
		while(!validInput);
	}
	//if 0 is entered set repeat to false, this terminates the program
	{
		if(amount_left == 0)
		{
			repeat = false;
		}
		else
		{
			cout<< amount_left <<" cents can be given as ";
			compute_coins(25, num, amount_left);
			//generates number of quarters
			if(num!=0)
			{
				if(num==1)
					cout<< num << " quarter";
				else
					cout<< num << " quarters";
				if(amount_left!=0)
					cout<<", ";
			}
			compute_coins(10, num, amount_left);
			//generates number of dimes
			if(num!=0)
			{
				if(num==1)
					cout<< num << " dime";
				else
					cout<< num << " dimes";
				if(amount_left!=0)
					cout<<", ";
			}
			// amount left would be just the pennies
			if(amount_left!=0)
			{
				if(amount_left==1)
					cout<< amount_left << " penny";
				else
					cout<< amount_left << " pennies";
			}
			cout<<"."<<endl;
		}
	}
	return 0;
}

void compute_coins(int coin_value, int& num, int& amount_left)
// function definition
{
	number = amountLeft / coinValue;
	amountLeft = amountLeft % coinValue;
}
