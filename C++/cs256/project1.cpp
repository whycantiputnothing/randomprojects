#include <iostream>
#include <time.h>
using namespace std;

void pause( int milliseconds ) {
        int limit = clock() + milliseconds * CLOCKS_PER_SEC / 1000;
        while ( clock() < limit ) {
                // Do nothing...just wait
        }
}

int main() {
        char ESC = 27;
        int count = 0;
        char color = ' ';
        bool complete = false;

        cout << ESC << "[2J"; // Clear Screen
        cout << ESC << "[40m";
        for(int k = 0; k < 8; k++) {
                for(int j = 0; j < 159; j++) {
                        cout << ESC << "[13;0f"; // Move cursor to 13, 0
                        for(int i = 0; i < 80; i++) {
                                if (i == count) {
                                        color = '0' + k;
                                        cout << ESC << "[3" << color << "m" << flush;
                                        cout << "O" << flush;
                                }
                                else {
                                        cout << ESC << "[39m" << flush;
                                        cout << "o" << flush;
                                }
                        }

                        if (j > 78)
                                complete = true;
                        if (!complete)
                                count++;
                        else
                                count--;
                        pause(10);
                        if ( !(k == 7 && j == 158) )
                                cout << ESC << "[2J" << flush; // clear screen
                }
                complete = false;
                count = 0;
        }

        cout << endl;
        cout << ESC << "[39;49m";
        return 0;
}
