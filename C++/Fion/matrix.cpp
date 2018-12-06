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
	int k=0,l=0,m=0,n=0;
	int i=0,j=0;

	cout<<"Enter first matrix:\n";

	while(true)
	{
		//Read string from keyboard
		getline(std::cin,input);
		if(input.empty())
		{
			break;
		}
		j=0;
		while(input.size() > 0) {
			space = false;
			for (int z = 0; z < input.size(); z++) {
				if (input[z] == ' ') {
					str = input.substr(0, z);
					value = atoi(str.c_str());
					input = input.substr(z + 1, input.size());
					matrixA[i][j] = value;
					j++;
					space = true;
					break;
				}
			}
			if (!space) {
				value = atoi(input.c_str());
				input = "";
				matrixA[i][j] = value;
				j++;
			}
		}
		i++;
	}
	//Assign row and column length
	k=i;
	l=j;

	cout<<"Enter second matrix:\n";
	i=0;
	while(true)
	{
		//Read string from keyboard
		getline(std::cin,input);
		if(input.empty())
		{
			break;
		}
		j=0;
		while(input.size() > 0) {
			space = false;
			for (int z = 0; z < input.size(); z++) {
				if (input[z] == ' ') {
					str = input.substr(0, z);
					value = atoi(str.c_str());
					input = input.substr(z + 1, input.size());
					matrixB[i][j] = value;
					j++;
					space = true;
					break;
				}
			}
			if (!space) {
				value = atoi(input.c_str());
				input = "";
				matrixB[i][j] = value;
				j++;
			}
		}
		i++;
	}
	//Assign row and column length
	m=i;
	n=j;

	if(l==m)
	{
		//Multiplication logic
		for(i=0; i<k; i++)
		{
			for(j=0; j<n; j++)
			{
				result[i][j]=0;
				for(int d=0; d<m; d++)
				{
					result[i][j]=result[i][j]+matrixA[i][d]*matrixB[d][j];
				}
			}
		}

		cout<<"The product is:\n";
		//Display matrix result
		for(i=0; i<k; i++)
		{
			for(j=0; j<n; j++)
			{
				cout<<result[i][j]<<" ";
			}
			cout<<endl;
		}
	}
	else
	{
		cout<<"The two matrices have incompatible dimensions.\n";
	}
	return 0;
}
