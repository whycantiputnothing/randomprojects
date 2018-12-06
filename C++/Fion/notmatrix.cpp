#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

int main()
{
	string input;
	string str;
	int value;
	bool space;
	int matrixA[10][10],matrixB[10][10],result[10][10];
	int r1=0,c1=0,r2=0,c2=0;
	int i=0,j=0;
	cout<<"Enter first matrix:"<<endl;
	while(true)
	{
		//user input for matrix b
		getline(std::cin,input);
		if(input.empty())
		{
			//if nothing was entered
			break;
		}
		j=0;
		while(input.size() > 0)
		{
			//to make input into matrix b
			//to help calculate numbers of rows and columns
			space = false;
			for (int z = 0; z < input.size(); z++)
			{
				if (input[z] == ' ')
				{
					str = input.substr(0, z);
					value = atoi(str.c_str());
					input = input.substr(z + 1, input.size());
					matrixA[i][j] = value;
					j++;
					space =true;
					break;
				}
			}
			if (!space)
			{
				value = atoi(input.c_str());
				input = "";
				matrixA[i][j] = value;
				j++;
			}
		}
		i++;
	}
	//Assign row and column length
	r1=i;
	c1=j;
	cout<<"Enter second matrix:"<<endl;
	i=0;
	while(true)
	{
		//user input for matrix b
		getline(std::cin,input);
		if(input.empty())
		{
			//if nothing was entered
			break;
		}
		j=0;
		while(input.size() > 0)
		{
			//to make input into matrix b
			//to help calculate numbers of rows and columns
			space = false;
			for (int z = 0; z < input.size(); z++)
			{
				if (input[z] == ' ')
				{
					str = input.substr(0, z);
					value = atoi(str.c_str());
					input = input.substr(z + 1, input.size());
					matrixB[i][j] = value;
					j++;
					space =true;
					break;
				}
			}
			if (!space)
			{
				value = atoi(input.c_str());
				input = "";
				matrixB[i][j] = value;
				j++;
			}
		}
		i++;
	}
	//Assign row and column length
	r2=i;
	c2=j;
	if(c1==r2)
	{
		//calculate product
		for(i=0; i<r1; i++)
		{
			for(j=0; j<c2; j++)
			{
				result[i][j]=0; //initialize resulting array
				for(int d=0; d<r2; d++)
				{
					result[i][j]=result[i][j]+matrixA[i][d]*matrixB[d][j]; //multiplies matrices
				}
			}
		}
		cout<<"The product is:"<<endl;
		//Displays results
		for(i=0; i<r1; i++)
		{
			for(j=0; j<c2; j++)
			{
				cout<<result[i][j]<<" ";
			}
			cout<<endl;
		}
	}
	else
	// error statement
	{
		cerr<<"The two matrices have incompatible dimensions."<<endl;
	}
	return 0;
}
