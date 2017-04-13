#include <iostream>
#include <fstream>
using namespace std;

int main() {
  ofstream outputFile;
  int input;

  outputFile.open("copy.dat");

  if (!outputFile)
    cout << "failed to open file";
    else {
      for (int i = 0; i < 1000; i++) {
          cin >> input;
          outputFile << input << endl;
      }
    }
    outputFile.close();

}
