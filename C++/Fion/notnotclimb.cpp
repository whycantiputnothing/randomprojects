#include <iostream>
#include <string>
#include <cmath>
#include <cstdlib>
using namespace std;

void fillUpArray(int height[][10], int maxSize)
{
	string input;
	int rowNum=0, colNum=0;
	cout << "Enter height:"<<endl;
	getline(cin, input);
	while(!input.empty())
	{
		int currColNum=0;
		for(int i=0; i<input.length(); i++)
		{
			if (input[i] != ' ')
			{
				int iterator = i;
				while(input[iterator] != ' ' && iterator < input.length())
				{
					iterator++;
				}
				height[rowNum][currColNum] = stoi(input.substr(i,iterator - i));
				i = iterator;
				currColNum++;
			}
		}
		getline(cin, input);
		rowNum++;
		colNum= currColNum;
	}
}

int main()
{
	int height[10][10];
	for(int i = 0; i < 10; i++)
	{
		for(int j = 0; j < 10; j++)
		{
			height[i][j] = -1;
		}
	}
	fillUpArray(height, 10);
	int numRow = 0;
	int numCol = 0;
	bool done = false;
	int iterator = 0;
	while(!done && iterator < 10)
	{
		if(height[iterator][0] < 0)
		{
			done = true;
			numRow = iterator;
		}
		iterator++;
	}
	done=false;
	iterator=0;
	while(!done && iterator < 10)
	{
		if(height[0][iterator] < 0)
		{
			done = true;
			numCol = iterator;
		}
		iterator++;
	}
	int maxRow(0), minRow(0), maxCol(0), minCol(0);
	for (int i=0; i< numRow; i++)
	{
		for(int j=0; j< numCol; j++)
		{
			if( height[i][j] >= height[maxRow][maxCol])
			{
				maxRow = i;
				maxCol = j;
			}
			else if( height[i][j] <= height[minRow][minCol])
			{
				minRow = i;
				minCol= j;
			}
		}
	}
	double height_diff = height[maxRow][maxCol]-height[minRow][minCol];
	double distance = sqrt((pow(maxRow-minRow,2) + pow(maxCol-minCol,2)));
	double angle =atan2(height_diff, distance);
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(3);
	cout << "The angle of the climb is " << angle << " radians." << endl;
	return 0;
}
