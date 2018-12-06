//
//  climb.cpp
//  PA07 - Climb
//
//  Created by Chad Spensky on 7/26/16.
//  Copyright © 2016 Chad Spensky. All rights reserved.
//


#include <iostream>
#include <string>
#include <cmath>
#include <cstdlib>

using namespace std;

// How many rows and columns can we read?
const int rows = 10;
const int columns = 10;

void getInput(int heights[10][10]) {
	cout << "Enter heights:" << endl;
	string line = "";
	string str;

	bool space;
	for (int r = 0; r < rows; r++) {
		getline(cin, line);

		// Did they enter nothing?
		if (line == "") {
			break;
		}

		for (int c = 0; c < columns; c++) {
			space = false;
			for (int z = 0; z < line.size(); z++) {
				if (line[z] == ' ') {
					str = line.substr(0, z);
					line = line.substr(z + 1, line.size());
					heights[r][c] = atoi(str.c_str());
					space = true;
					break;
				}
			}
			if(!space) {
				line = "";
				heights[r][c] = atoi(line.c_str());
			}
		}
	}
}

int main(int argc, const char * argv[]) {



	// Initialize our heights to -1
	int heights[rows][columns] = {-1};

	// Read in input from the user
	getInput(heights);

	// Get min and max values
	int min_r = 0, min_c = 0;
	int max_r = 0, max_c = 0;
	int max_val = heights[0][0];

	// Loop over the rows
	for (int r = 0; r < rows; r++) {
		// Loop over the columns
		for (int c = 0; c < columns; c++) {
			// Is there a bigger value?
			if (heights[r][c] > heights[max_r][max_c]) {
				max_r = r;
				max_c = c;
			}
			// Is there a smaller value?
			if (heights[r][c] > 0 &&
			    heights[r][c] < heights[min_r][min_c]) {
				min_r = r;
				min_c = c;
			}
		}
	}

	// Calculate our height and distance
	double height_diff = heights[max_r][max_c] - heights[min_r][min_c];
	double distance = sqrt(pow(max_r-min_r,2)+pow(max_c-min_c,2));

	// Calculate our angle
	double angle = atan2(height_diff,distance);

	// Some debug stuff
//    cout << max_r << " " << max_c << endl;
//    cout << min_r << " " << min_c << " " << heights[min_r][min_c] <<endl;
//    cout << height_diff << endl;
//    cout << distance << endl;

	// Set floating point output to 'fixed point'
	cout.setf(ios::fixed);
	// Show the decimal point (even if it's a whole number
	cout.setf(ios::showpoint);
	// Set the precision to 4 decimal points
	cout.precision(3);

	// Output our answer
	cout << "The angle of the climb is " << angle << " radians." << endl;
}
