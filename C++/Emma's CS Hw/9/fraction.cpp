#include <iostream>
#include "fraction.h"
using namespace std;

fraction::fraction() {
	numerator = 0;
	denominator = 1;
}

fraction::fraction(int num, int den) {
	numerator = num;
	denominator = den;
}

void fraction::simplify() {
	for (int i = denominator * numerator; i > 1; i--) {
		if ((denominator % i == 0) && (numerator % i == 0)) {
			denominator /= i;
			numerator /= i;
		}

	}
}

void fraction::print() const {
	cout << numerator << "/" << denominator;
}

fraction fraction::addedTo(const fraction &f1) const {
	fraction f(numerator, denominator);
	f.simplify();
	fraction otherF(f1.numerator, f1.denominator);
	otherF.simplify();
	int num = f.numerator * otherF.denominator + otherF.numerator * f.denominator;
	int den = f.denominator * otherF.denominator;
	fraction foo(num, den);
	foo.simplify();
	return foo;

}

fraction fraction::subtract(const fraction &f1) const {
	fraction f(numerator, denominator);
	f.simplify();
	fraction otherF(f1.numerator, f1.denominator);
	otherF.simplify();
	int num = f.numerator * otherF.denominator - otherF.numerator * f.denominator;
	int den = f.denominator * otherF.denominator;
	fraction foo(num, den);
	foo.simplify();
	return foo;

}

fraction fraction::multipliedBy(const fraction &f1) const {
	fraction f(numerator, denominator);
	f.simplify();
	fraction otherF(f1.numerator, f1.denominator);
	otherF.simplify();
	int num = f.numerator * otherF.numerator;
	int den = f.denominator * otherF.denominator;
	fraction foo(num, den);
	foo.simplify();
	return foo;
}

fraction fraction::dividedBy(const fraction &f1) const  {
	fraction f(numerator, denominator);
	f.simplify();
	fraction otherF(f1.numerator, f1.denominator);
	otherF.simplify();
	int num = f.numerator * otherF.denominator;
	int den = f.denominator * otherF.numerator;
	fraction foo(num, den);
	foo.simplify();
	return foo;
}

bool fraction::isEqualTo(const fraction &otherF) const {
	return numerator * otherF.denominator == denominator * otherF.numerator;
}
