// example0501.cpp
//  To be done in class
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;
const double pi = 3.1415;
int main() {
        string shape = "";
        double area;
        double radius;
        double length;
        double height;
        char selection;

        cout << "Enter data (shape, val1, [val2]) : ";
        cin >> shape;
        selection = shape[0];
        while (selection != 'q') {
                switch(selection) {
                case 'c':
                        shape = "Circle";
                        cin >> radius;
                        area = pi * radius * radius;
                        break;
                case 'r':
                        shape = "Rectangle";
                        cin >> length >> height;
                        area = length * height;
                        break;
                case 't':
                        shape = "Triangle";
                        cin >> length >> height;
                        area = 0.5 * length * height;
                        break;
                default:
                        break;
                }
                cout <<  setw(10) << left << shape << setw(8) << setprecision(2) << fixed<< area << endl;
                cout << "Enter data (shape, val1, [val2]) : ";
                cin >> shape;
                selection = shape[0];
        }


        return 0;
}
