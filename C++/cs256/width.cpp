#include <iostream>
#include <iomanip>

using namespace std;

int main(){
        int time1[] = {1000, 221, 3321, 4456, 5123};
        int time2[] = {1000, 221, 3321, 4456, 5123};
        int run = 10;

        cout << left << setw(20) << "size" << setw(20) << "time" << setw(20) << "time2" << endl;
        cout << setfill('-') << setw(60) << "-" << endl << setfill(' ');

        for (int i = 0; i < 5; i++) {
                cout << setw(20) << run;
                run *= 10;
                cout << setw(20) << time1[i] << time2[i] << endl;
        }
}
