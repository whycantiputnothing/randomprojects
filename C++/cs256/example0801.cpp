#include <iostream>
#include <fstream>

using namespace std;

int main(){
  ofstream inputfile;
  inputfile.open( "file.txt" );
  if (!inputfile)
    cout << "failed to make file";
    else {
      for (int i = 0; i < 1000; i++) {
          inputfile << i << endl ;
      }
    }

}
