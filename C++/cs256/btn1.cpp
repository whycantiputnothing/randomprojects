#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct move {
	int row;
	int col;
};

int eval(char board[], char self, char foe);
bool hasMoves(char board[]);
void getBoard(char* fileName, char board[]);
void putBoard(char* fileName, char board[10]);
void findBestMove(char board[10], char self, char foe);

move makeMove = {-1, -1};

int main( int cnt, char* args[] ) {
	char board[10];
	char self;
	char foe;
	int end;
	self = toupper(args[2][0]);
	if (self == 'X')
		foe = 'O';
	else
		foe = 'X';
	getBoard(args[1], board);
	findBestMove(board, self, foe);
	if (makeMove.row == -1 || makeMove.col == -1)
		cout << "error: bad board\n";
	else {
		board[makeMove.row*3 + makeMove.col] = self;
		putBoard(args[1], board);
		end = eval(board, self, foe);
		if (end != 0) {
			if (end > 0)
				cout << self << " Wins!" << endl;
			else
				cout << foe << " Wins!" << endl;
		}
		else {
			if (!hasMoves(board))
				cout << "It's a Tie!" << endl;
		}
	}
	return 0;
}

bool hasMoves(char board[]) {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (board[i*3+j] == ' ')
				return true;
		}
	}
	return false;
}

int eval(char board[], char self, char foe) {
	for (int i = 0; i < 3; i++) {
		if (board[i*3] == board[i*3 + 1] && board[i*3 + 1] == board[i*3 + 2]) {
			if (board[i*3] == self)
				return 10;
			else if (board[i*3] == foe)
				return -10;
		}
		if (board[0 + i] == board[3 + i] && board[3 + i] == board[2*3 + i]) {
			if (board[  i] == self)
				return 10;
			else if (board[  i] == foe)
				return -10;
		}
	}

	if(board[0] == board[4] && board[4] == board[8]) {
		if (board[0] == self)
			return 10;
		else if(board[0] == foe)
			return -10;
	}

	if(board[2] == board[4] && board[4] == board[6]) {
		if (board[2] == self)
			return 10;
		else if (board[2] == foe)
			return -10;
	}

	return 0;
}

int minimax(char board[10], int depth, bool isMax, char self, char foe) {
	int score = eval(board, self, foe);

	if (score == 10)
		return score;

	if (score == -10)
		return score;

	if (!hasMoves(board))
		return 0;

	if (isMax) {
		int best = -1000;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i*3 + j] == ' ') {
					board[i*3 + j] = self;
					best = max (best, minimax(board, depth + 1, !isMax, self, foe));
					board[i*3 + j] = ' ';

				}
			}
		}
		return best;
	}

	else {
		int best = 1000;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i*3 + j] == ' ') {
					board[i*3 + j] = foe;
					best = min(best,minimax(board, depth + 1, !isMax, self, foe));
					board[i*3 + j] = ' ';
				}
			}
		}
		return best;
	}
}

void findBestMove(char board[10], char self, char foe) {
	int best = -1000;
	int move = 0;

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (board[i*3 + j] == ' ') {
				board[i*3 + j] = self;
				move = minimax(board, 0, false, self, foe);
				board[i*3 + j] = ' ';

				if (move > best) {
					makeMove.row = i;
					makeMove.col = j;
					best = move;
				}
			}
		}
	}
}

void putBoard(char* fileName, char board[10]) {
	ofstream output(fileName);
	int count = 0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			output.put(board[i*3 + j]);
		}
		output << "\n";
	}
	output.close();
}

void getBoard(char* fileName, char board[]) {
	ifstream input(fileName);
	int j = 0;
	char buffer;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			input.get(board[i*3+j]);
		}
		input.ignore(4, '\n');
	}
	input.close();
}
