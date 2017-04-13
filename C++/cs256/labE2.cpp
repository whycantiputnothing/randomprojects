#include <iostream>
#include <cstdlib>   // needed for atoi()
#include <string>
#include <fstream>
#include <iomanip>
using namespace std;

int main( int cnt, char* argv[] ) {
  string src_filename = argv[1];
  string dst_filename = argv[2];
  int total_bytes = atoi( argv[3] );
  string String;
  string bar = ">";
  int counter = 0;
  char c;

    ifstream inputFile;
    inputFile.open(src_filename.c_str());
    ofstream outputFile;
    outputFile.open(dst_filename.c_str());
    if (!inputFile) {
      cout << "Error: unable to read" << src_filename << endl;
    }
    cout << char(27) << "[2J";

    while(inputFile.get(c)) {

        outputFile << c;
        counter++;

        cout << (double)counter/total_bytes*100 << "%" << endl;
        cout << char(27) << "[0;0f"; // Move cursor to 13, 0
    }

    cout << counter << endl;
    inputFile.close();
    outputFile.close();
    return 0;
  }
