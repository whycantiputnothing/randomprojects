#include <iostream>
#include <string>
#include <cmath>
#include <cstdlib>

using namespace std;

const int rows = 10;
const int columns = 10;

void getInput(int heights[10][10])
{
	//function to get input
	cout << "Enter heights:" << endl;
	string line = ""; //initialize string
	string str; //initialize string
	bool space; //declare bool
	for (int r = 0; r < rows; r++)
	{
		getline(cin, line);
		if (line == "")
		{
			//if nothing was entered
			break;
		}
		for (int c = 0; c < columns; c++)
		{
			space = false;
			for (int z = 0; z < line.size(); z++)
			{
				if (line[z] == ' ')
				{
					str = line.substr(0, z);
					line = line.substr(z + 1, line.size());
					heights[r][c] = atoi(str.c_str());
					space = true;
					break;
				}
			}
			if(!space)
			{
				line = "";
				heights[r][c] = atoi(line.c_str());
			}
		}
	}
}


int main()
{
	int heights[rows][columns] = {-1}; //initialize heights to -1
	getInput(heights);
	// Get min and max values
	int min_r = 0, min_c = 0;
	int max_r = 0, max_c = 0;
	int max_val = heights[0][0];
	for (int r = 0; r < rows; r++)
	{
		// Loop over the columns
		for (int c = 0; c < columns; c++)
		{
			if (heights[r][c] > heights[max_r][max_c])
			{
				max_r = r;
				max_c = c;
			}
			if (heights[r][c] > 0 && heights[r][c] < heights[min_r][min_c])
			{
				min_r = r;
				min_c = c;
			}
		}
	}
	// Calculation for height and distance
	double height_diff = heights[max_r][max_c] - heights[min_r][min_c];
	double distance = sqrt(pow(max_r-min_r,2)+pow(max_c-min_c,2));
	// Calculate for angle
	double angle = atan2(height_diff, distance);
	// Set fixed point
	cout.setf(ios::fixed);
	//to always show decimal point
	cout.setf(ios::showpoint);
	// Set the precision up to 3 decimal points
	cout.precision(3);
	cout << "The angle of the climb is " << angle << " radians." << endl;
	return 0;
}
