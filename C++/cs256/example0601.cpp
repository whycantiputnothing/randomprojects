#include <iostream>
#include <string>

using namespace std;

string hex(int);
string oct(int);
int main(){
        int num;

        cin >> num;
        cout << num << endl;
        cout << hex(num) << endl;
        cout << oct(num) << endl;

}

string hex(int num) {
        string hexa = "";
        char temp;
        while (num != 0) {
                temp = num % 16;

                if (temp < 10)
                        temp += 48;
                else
                        temp += 55;

                hexa = temp + hexa;
                num = num / 16;
        }

        return "0x" + hexa;

}

string oct(int num) {
        string octa = "";
        char temp;
        while (num != 0) {
                temp = num % 8;
                temp += 48;
                octa = temp + octa;
                num = num / 8;
        }

        return "0" + octa;

}
