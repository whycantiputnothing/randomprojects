// Write a program to read in 1000 strings from a file called
// "unsorted.dat", sort the list, and then save the results to a file
// called "sorted.dat"

#include <iostream>
#include <fstream>
#include <cstdlib>
using namespace std;

bool read_strings( string, string[], int );
void sort( string[], int );
bool save( string[], int, string );

int main () {
  string input_filename  = "unsorted.dat";
  string output_filename = "sorted.dat";
  int size = 20;
  string list[ size ];
  bool success;

  success = read_strings( input_filename, list, size );

  if ( success ) {
    sort( list, size );
    save( list, size, output_filename );
  }

  return 0;
}

bool read_strings( string infilename, string list[], int size ) {

  ifstream input_file( infilename.c_str() );

  if ( ! input_file ) {
    cout << "ERROR: Unable to read " << infilename << endl;
    return false;
  }

  for ( int i = 0; i < size; i++ ) {
    input_file >> list[ i ];
  }
  input_file.close();
  return true;
}

void sort( string list[], int size ) {
  int min = 0;
  for (int i = 0; i < size - 1; i++) {
    min = i;
    for (int j = i + 1; j < size; j++) {
      if (list[j] < list[min])
      min = j;
      int temp = list[i];
      list[i] = list[min];
      list[min] = temp;
    }
  }
}

bool save( string list[], int size, string filename ) {
  ofstream outfile( filename.c_str() );

  if ( ! outfile ) {
    cout << "ERROR: Unable to write to " << filename << ". " << endl;
    return false;
  }

  for ( int i = 0; i < size; i++ )
    outfile << list[ i ] << endl;
  outfile.close();
  return true;
}
