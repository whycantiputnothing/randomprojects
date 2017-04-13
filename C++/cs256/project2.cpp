#include <iostream>
#include <string>
#include <sstream>
#include <fstream>
using namespace std;

void wait (int);
void error (int, string, ofstream&);
void error (int, string, int, ofstream&);
void printArray(char[4][25][80]);
void intializeArray(char[4][25][80], int);
void selectCommand(string, int, ofstream&, char[4][25][80]);
void plot (char screen[4][25][80], int x, int y, char c);
void clear();
bool rowRange(int, int);
void quit();
void move (char screen[4][25][80], int row, int col, int h, int w, int dr, int dc);
void copy (char screen[4][25][80], int row, int col, int h, int w, int dr, int dc);
void printChar(int, int, char);

bool colRange(int, int);

bool fast;
bool end = false;
bool skip;
int ms;
int textColor;
int backgroundColor;

int main(int cnt, char* args[]) {
	ifstream file;
	ofstream outfile;
	string input;
	string command_file = args[1];
	int lineCounter = 1;
	char screen[4][25][80];

	file.open(command_file.c_str());
	outfile.open("project2.log");
	intializeArray(screen, 0);

	cout << char(27) << "[2J"; // Clear Screen

	while (getline(file, input) && !end) {
		selectCommand(input, lineCounter, outfile, screen);
		lineCounter++;
		if(!fast && !end && !skip) {
			cout << flush;
			wait(ms);
		}
		skip = false;
	}

	outfile.close();
	file.close();
	return 0;
}

void wait( int milliseconds ) {
	int limit = clock() + milliseconds * CLOCKS_PER_SEC / 1000;
	while ( clock() < limit ) {
		// Do nothing...just wait
	}
}

void selectCommand(string input, int lineCounter, ofstream& outfile, char screen[4][25][80]) {
	stringstream stream;
	string command;
	stream << input;
	stream >> command;
	if (command == "clear") {
		intializeArray(screen, 0);
		cout << char(27) << "[2J"; // Clear Screen
		cout << flush;
	}
	else if (command == "setms") {
		stream >> ms;
	}
	else if (command == "setfg") {
		string str = "";
		ostringstream convert;
		stream >> textColor;
		if (textColor > 29 && textColor < 40) {
			convert << textColor;
			str = "[" + convert.str() + "m";
			cout << char(27) << str;
		}
		else
			error(lineCounter, command, textColor, outfile);
	}

	else if (command == "setbg") {
		ostringstream convert;
		string str = "";
		stream >> backgroundColor;
		if (backgroundColor > 39 && backgroundColor < 51) {
			convert << backgroundColor;
			str = "[" + convert.str() + "m";
			cout << char(27) << str;
		}
		else {
			error(lineCounter, command, backgroundColor, outfile);
		}

	}

	else if (command == "pause") {
		cout << flush;
		wait(ms);
	}

	else if (command == "slow") {
		fast = false;
	}

	else if (command == "fast") {
		fast = true;
	}

	else if (command == "plot") {
		int row;
		int col;
		char c;
		stream >> row >> col >> c;
		plot(screen, row, col, c);

	}

	else if (command == "hplot") {
		int row;
		int col;
		int cnt;
		char c;

		stream >> row >> col >> c >> cnt;
		while (col <= 80 && cnt > 0) {
			plot(screen, row, col, c);
			col++;
			cnt--;
		}
	}

	else if (command == "vplot") {
		int row;
		int col;
		int cnt;
		char c;

		stream >> row >> col >> c >> cnt;
		while (row <= 25 && cnt > 0) {
			plot(screen, row, col, c);
			row++;
			cnt--;
		}
	}

	else if (command == "text") {
		int row;
		int cnt;
		int col;
		int length;
		string String;
		stream >> row >> col;
		if (col < 10)
			cnt = 9;
		else
			cnt = 10;
		String = stream.str();
		length = String.length();
		while (col < 81 && cnt < length - 1) {
			plot(screen, row, col, String[cnt]);
			col++;
			cnt++;
		}
	}

	else if (command == "move") {
		int row, col, h, w, dr, dc;
		stream >> row >> col >> h >> w >> dr >> dc;
		move(screen, row, col, h, w, dr, dc);
	}

	else if (command == "copy") {
		int row, col, h, w, dr, dc;
		stream >> row >> col >> h >> w >> dr >> dc;
		copy(screen, row, col, h, w, dr, dc);
	}

	else if (command[0] == '/' && command[1] == '/' || command.length() == 0) {
		skip = true;
	}

	else if (command == "quit") {
		quit();
		end = true;
	}

	else {
		error(lineCounter, command, outfile);
		skip = true;
	}
}

void clear(){
	cout << char(27) << "[2J"; // Clear Screen
}

void plot (char screen[4][25][80], int x, int y, char c){
	screen[0][x - 1][y - 1] = c;
	printChar(x,y,c);
}

void move (char screen[4][25][80], int row, int col, int h, int w, int dr, int dc) {
	char c;
	for (int i = row - 1; i < row - 1 + h; i++) {
		for (int j = col - 1; j < col - 1 + w; j++) {
			if (rowRange(i,dr) && colRange(j,dc)) {
				c = screen[0][i][j];
				screen[1][i + dr][j + dc] = c;
			}
			screen[0][i][j] = ' ';
			printChar(i + 1, j + 1, ' ');
		}
	}
	for (int i = row - 1; i < row - 1 + h; i++) {
		for (int j = col - 1; j < col -1 + w; j++) {
			if (rowRange(i,dr) && colRange(j,dc)) {
				c = screen[1][i + dr][j + dc];
				printChar(i + dr + 1, j + dc + 1, c);
				screen[0][i + dr][j + dc] = c;
			}
		}
	}
}

bool colRange(int row, int dr) {
	return !(row + dr > 79 || row + dr < 0);
}

bool rowRange(int col, int dc) {
	return !(col + dc > 24 || col + dc < 0);
}
void copy (char screen[4][25][80], int row, int col, int h, int w, int dr, int dc) {
	char c;
	for (int i = row - 1; i < row - 1 + h; i++) {
		for (int j = col - 1; j < col - 1 + w; j++) {
			if (rowRange(i,dr) && colRange(j,dc)) {
				c = screen[0][i][j];
				screen[1][i + dr][j + dc] = c;
			}
		}
	}
	for (int i = row - 1; i < row - 1 + h; i++) {
		for (int j = col - 1; j < col -1 + w; j++) {
			if (rowRange(i,dr) && colRange(j,dc)) {
				c = screen[1][i + dr][j + dc];
				printChar(i + dr + 1, j + dc + 1, c);
				screen[0][i + dr][j + dc] = c;
			}
		}
	}
}


void quit(){
	char c;
	cout << char(27) << "[25;0f";
	cout << char(27) << "[39;49m";

	cout << "\nPress enter to quit" << flush;
	c = cin.get();

}

void intializeArray(char array[4][25][80], int x) {
	for (int i = 0; i < 25; i++) {
		for (int j = 0; j < 80; j++) {
			array[x][i][j] = ' ';
		}
	}
}

void printChar(int row, int col, char c) {
	cout << char(27) << "[" << row << ";" << col << "f"; // Move cursor to i, j
	cout << c;
	cout << char(27) << "[0;0f";
}

void printArray(char array[4][25][80]) {
	char c;
	for (int i = 0; i < 25; i++) {
		for (int j = 0; j < 80; j++) {
			c = array[1][i][j];
			cout << char(27) << "[" << i << ";" << j << "f"; // Move cursor to i, j
			cout << c;

		}
	}
	cout << char(27) << "[0;0f"; // Move cursor to 0, 0
}

void error(int lineNum, string command, ofstream& ofile){
	ofile << "Error: Line " << lineNum << " - invalid command '" << command
	      << "', skipping" << endl;
}

void error(int lineNum, string command, int color, ofstream& ofile) {
	ofile << "Error: Line " << lineNum << " - invalid color '" << color
	      << "', for command '" << command << "', skipping" << endl;

}
