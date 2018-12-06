#include <iostream>
using namespace std;

//function prototype
void compute_coins(int coin_value, int& num, int& amount_left);

int main()
{
	bool repeat = true;
	//repeat a loop until repeat is true (repeat will be set to false when use enters 0)
	while(repeat)
	{
		int amount_left;
		int num;

		//run a loop until valid amount is entered, accept numbers between 1 and 100
		cout<< "Enter number of cents (or zero to quit): "<<endl;
		cin>> amount_left;
		//if 0 is entered set repeat to false, this terminates the program
		if(amount_left == 0)
		{
			repeat = false;
		}
		else
		{
			//print the amount entered and a text follwing it
			cout<< amount_left <<" cents can be given as ";

			// get the number of quarters using compute_coins method
			compute_coins(25, num, amount_left);
			//if num is greater than 0 then print it
			if(num!=0)
			{
				//if num is 1 print num followed by quarter
				if(num==1)
					cout<< num << " quarter";
				else
					//else print num followed by quarter
					cout<< num << " quarters";
				//if amount_left is not 0 then print a ','
				if(amount_left!=0)
					cout<<", ";
			}

			//get the number of dimes using the compute_coins method
			compute_coins(10, num, amount_left);
			//if num is greater than 0 then print it
			if(num!=0)
			{
				//if num is 1 print num followed by dime
				if(num==1)
					cout<< num << " dime";
				else
					//else print num followed by dimes
					cout<< num << " dimes";
				//if amount_left is not 0 then print a ','
				if(amount_left!=0)
					cout<<", ";
			}

			//the value in amount_left will be number of pennies
			if(amount_left!=0)
			{
				//if amount_left is 1 print num followed by penny
				if(amount_left==1)
					cout<< amount_left << " penny";
				else
					//else print amount_left followed by pennies
					cout<< amount_left << " pennies";
			}
			//print a '.' at the end the statement
			cout<<"."<<endl;
		}
	}

	return 0;
}

// Precondition: 0 < coin_value < 100; 0 <= amount_left < 100.
// Postcondition: num has been set equal to the maximum number
// of coins of denomination coin_value cents that can be obtained
// from amount_left. Additionally, amount_left has been decreased
// by the value of the coins, that is, decreased by
// num * coin_value.
void compute_coins(int coin_value, int& num, int& amount_left)
{
	//get the number of coins based on coin_value
	num = amount_left / coin_value;
	//reduce the amount_left by assigning it the remainder of amount_left / coin_value
	amount_left = amount_left % coin_value;
}
