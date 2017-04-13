// example0502.cpp
//  To be done in class
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

const double pi = 3.1415;

char get_selection();
void compute_display_area(char);
double compute_circle();
double compute_rectangle();
double compute_triangle();
void output(string, double);
int main() {
        char c;
        do {
                c = get_selection();
                if (c != 'q')
                        compute_display_area(c);
        } while (c != 'q');

        return 0;
}

char get_selection() {
        string shape;

        cout << "Enter data (shape, val1, [val2] ) : ";
        cin >> shape;
        return shape[0];
}

void compute_display_area (char d) {
        switch (d) {
        case 'c':
                output("Circle", compute_circle());
                break;
        case 'r':
                output("Rectangle", compute_rectangle());
                break;
        default:
                output("Triangle", compute_triangle());
        }
}

double compute_circle() {
        double radius;
        cin >> radius;
        return pi * radius * radius;
}

double compute_rectangle() {
        double l, w;
        cin >> l >> w;
        return l * w;
}

double compute_triangle() {
        return 0.5 * compute_rectangle();
}

void output(string shape, double area){
        cout <<  setw(10) << left << shape << setw(8) << setprecision(2) << fixed << area << endl;
}
