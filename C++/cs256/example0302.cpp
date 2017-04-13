// example0202.cpp
#include <iostream>
using namespace std;

int main() {
  int input = 0;
  int count = 0;
  int sum = 0;
  int average = 0;

  while(input > -1) {
    cout << "Input a number(negative to quit): \n";
    cin >> input;
    if (input > -1) {
      sum += input;
      count++;
    }
  }

  average = sum/count;
  cout << "Count: " << count << endl;
  cout << "Sum: " << sum << endl;
  cout << "Average: " << average << endl;
}
