#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main()
{
   int counter = 0, kcounter = 0, n = 0, k = 0, face = 0;
   srand(time(0));

   cout << "times die rolled" << endl;
   cin >> n;
   cout << "face on die" << endl;
   cin >> k;

   while (counter < n) {
       face = rand() % 6 + 1;
       if (face == k) {
           kcounter++;
       }
       counter++;
   }

   cout << kcounter << endl;

   return 0;
}

