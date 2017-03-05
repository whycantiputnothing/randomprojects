#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib>
#include <ctime>
#include <iomanip>
using namespace std;

struct pokemon {
	string name;
	string type;
	string moves[3];
	int lvl;
	int HP;
	int maxHP;
	int attack;
	int defense;
	int speed;
};

void gameEngine();

pokemon list[3] = { {"Bulbasaur", "GRASS", {"Tackle", "Growl", "VineWhip"}, 12, 45, 45, 49, 49, 45},
		    {"Charmander", "FIRE", {"Scratch", "Growl", "Ember"}, 12, 39, 39, 52, 43, 65},
		    {"Squirtle", "WATER", {"Tackle", "TailWhip", "Bubble"}, 12, 44, 44, 48, 65, 43}};
string pkmn[3];
int numPkmn = 0;
int numBall = 0;
bool isCrit = false;
bool isOver = false;
bool isEffective = false;
pokemon myPoke = {"-","-"};
pokemon enemy = {"-","-"};

int main() {
	srand(time(0));
	gameEngine();
	return 0;
}

int randomNum(int max) {
	return rand() % max;
}

void saveState() {
	ofstream output("save.dat");
	output << myPoke.name << endl << myPoke.type << endl << myPoke.HP << endl
	       << myPoke.attack << endl << myPoke.defense << endl << myPoke.speed << endl
	       << myPoke.lvl << endl << myPoke.maxHP << endl

	       << enemy.name << endl << enemy.type << endl << enemy.HP << endl
	       << enemy.attack << endl << enemy.defense << endl << enemy.speed << endl
	       << enemy.lvl << endl << enemy.maxHP << endl

	       << numPkmn << endl << numBall << endl;
	for (int i = 0; i < numPkmn; i++) {
		output << pkmn[i] << endl;
	}

	output.close();
}

void loadState() {
	ifstream input("save.dat");
	input >> myPoke.name >> myPoke.type >> myPoke.HP >> myPoke.attack
	>> myPoke.defense >> myPoke.speed >> myPoke.lvl >> myPoke.maxHP

	>> enemy.name >> enemy.type >> enemy.HP >> enemy.attack
	>> enemy.defense >> enemy.speed >> enemy.lvl >> enemy.maxHP

	>> numPkmn >> numBall;

	for (int i = 0; i < numPkmn; i++) {
		input >> pkmn[i];
	}

	for(int i = 0; i < 3; i++) {
		if (myPoke.name == list[i].name) {
			for(int j = 0; j < 3; j++) {
				myPoke.moves[j] = list[i].moves[j];
			}
		}
		if (enemy.name == list[i].name) {
			for(int j = 0; j < 3; j++) {
				enemy.moves[j] = list[i].moves[j];
			}
		}
	}
	input.close();
}

double typeEffect(string me, string enemy) {
	double type = 1.0;
	if ( (me == "GRASS" && enemy == "FIRE") || (me == "FIRE" && enemy == "WATER")
	     || (me == "WATER" && enemy == "GRASS") ) {
		type = 0.5;
		cout << "It is not very effective..." << endl;
	}
	else if (me == "FIRE" && enemy == "GRASS" || (me == "WATER" && enemy == "FIRE")
	         || (me == "GRASS" && enemy == "WATER")) {
		type = 2;
		cout << "It is super effective!" << endl;
	}
	return type;
}

int getDamage(string move, int *attack, int *defense, int speed, int level, string type1, string type2) {
	int modifer;
	int damage = 0;
	int atk = *attack;
	int def = *defense;

	if ( randomNum(256) < (speed/2)) {
		level = level * 2;
		isCrit = true;
	}

	if (move == "Scratch" || move == "Tackle") {
		damage = ((((2.0 * level/5) + 2) * 40 * atk/def )/50) + 2;
	}
	else if(move == "Ember") {
		damage = ((((2.0 * level/5) + 2) * 40 * atk/def )/50) + 2;
		damage *= typeEffect(type1, type2);
	}
	else if(move == "VineWhip") {
		damage = ((((2.0 * level/5) + 2) * 45 * atk/def )/50) + 2;
		damage *= typeEffect(type1, type2);
	}
	else if(move == "Bubble") {
		damage = ((((2.0 * level/5) + 2) * 40 * atk/def )/50) + 2;
		damage *= typeEffect(type1, type2);
	}
	else if(move == "Growl") {
		atk = 0.93 * atk;
		*attack = atk;
	}
	else if(move == "TailWhip") {
		def = 0.93 * def;
		*defense = def;
	}
	return damage;

}

void newGame(){
	myPoke.HP = myPoke.maxHP;
	enemy = list[randomNum(3)];
	cout << "\nPress on to catch all the pokemon!" << endl
	     <<  "Another battle awaits against wild " << enemy.name << "!" << endl
	     << "Enemy" << setw(5) << "HP: " << enemy.HP << endl
	     << myPoke.name << "'s HP has been restored" << endl;
}

bool isCaught() {
	int m = randomNum(256);
	int f = (enemy.maxHP * 255 * 4 ) / (enemy.HP * 12);
	return (f >= m);
}

void battle (string str){
	string move = str.substr(7);
	string take = enemy.moves[randomNum(3)];
	int damage;
	if (myPoke.speed > enemy.speed && move != "catch") {
		cout << myPoke.name << " used " << move << "!" << endl;
		damage = getDamage(move, &(myPoke.attack), &(enemy.defense), myPoke.speed,
		                   myPoke.lvl, myPoke.type, enemy.type);
		if (isCrit && damage != 0) {
			cout << "A critical hit!" << endl;
			isCrit = false;
		}
		enemy.HP -= damage;
		if (enemy.HP < 1) {
			cout << "Enemy " << enemy.name << " has run out of HP. You win!" << endl;
			isOver = true;
		}
		if (!isOver) {
			cout << "The wild " << enemy.name << " used " << take << "!" << endl;
			damage = getDamage(take, &(enemy.attack), &(myPoke.defense), enemy.speed,
			                   enemy.lvl, enemy.type, myPoke.type);
			if (isCrit && damage != 0) {
				cout << "A critical hit!" << endl;
				isCrit = false;
			}
			myPoke.HP -= damage;
			if (myPoke.HP < 1) {
				cout << myPoke.name << " has run out of HP. You black out" << endl;
				isOver = true;
			}
		}
	}
	else {
		if (move == "catch") {
			if (numBall < 1)
				cout << "You have no more pokeballs" << endl;
			else {
				numBall--;
				cout << "You used a POKE BALL!" << endl;
				if(isCaught()) {
					cout << "All right! " << enemy.name << " was caught!" << endl;
					pkmn[numPkmn] = enemy.name;
					numPkmn++;
					newGame();
					return;
				}
				else
					cout << "Oh, no! The pokemon broke free!" << endl;
			}
			if (numBall < 1)
				cout << "You have no more pokeballs" << endl;
		}
		cout <<  "The wild " << enemy.name << " used " << take << "!" << endl;
		damage = getDamage(take, &(enemy.attack), &(myPoke.defense), enemy.speed,
		                   enemy.lvl, enemy.type, myPoke.type);
		if (isCrit && damage != 0) {
			cout << "A critical hit!" << endl;
			isCrit = false;
		}
		myPoke.HP -= damage;
		if (myPoke.HP < 1) {
			cout << myPoke.name << " has run out of HP. You black out" << endl;
			isOver = true;
		}
		if (!isOver && move != "catch") {
			cout << myPoke.name << " used " << move << "!" << endl;
			damage = getDamage(move, &(myPoke.attack), &(enemy.defense), myPoke.speed,
			                   myPoke.lvl, myPoke.type, enemy.type);
			if (isCrit && damage != 0) {
				cout << "A critical hit!" << endl;
				isCrit = false;
			}
			enemy.HP -= damage;
			if (enemy.HP < 1) {
				cout << "Enemy " << enemy.name << " has run out of HP." << endl;
				isOver = true;
			}
		}

	}
	if (isOver)
		newGame();
	else  {
		cout << "Enemy: " << enemy.name << endl
		     << "HP: " << enemy.HP << endl;

		cout << myPoke.name << ": " << endl
		     << "HP: " << myPoke.HP << endl;
	}
}

void gameEngine() {
	string input;
	loadState();
	getline(cin, input);
	if (input == "new") {
		cout << "Hello! Welcome to the world of Pokemon! Please choose your first Pokemon:" << endl
		     << "\t#1: Bulbasaur\n" << "\t#2: Charmander\n" << "\t#3: Squirtle\n";
		myPoke.lvl = -1;
		numBall = 3;
		numPkmn = 0;
	}
	else if(myPoke.lvl < 0) {
		for (int i = 0; i < 3; i++) {
			if (tolower(list[i].name[0]) == tolower(input[0]))
				myPoke = list[i];
		}
		input = myPoke.name;
		enemy = list[randomNum(3)];
		cout << "You have chosen " << input << " to be your first pokemon!\n"
		     << input << setw(5) << "HP: " << myPoke.HP << endl
		     <<  "A battle awaits against wild " << enemy.name << "!" << endl
		     << "Enemy" << setw(5) << "HP: " << enemy.HP << endl;

	}
	else if(myPoke.name == "-") {
		cout << "please start a new game\n";
	}
	else if(input.substr(0,6) == "battle") {
		battle(input);
	}
	else if(input == "moves") {
		cout << "You have these availible moves to make: " << endl;
		for (int i = 0; i < 3; i++)
			cout << myPoke.moves[i] << "\t";
		cout << endl;
	}
	else if (input == "catch") {

	}
	else if (input == "pkmn") {
		for (int i = 0; i < numPkmn; i++) {
			cout << pkmn[i] << "\t";
		}
		cout << endl;
	}
	else
		cout << "Wrong input\n";
	saveState();

}
