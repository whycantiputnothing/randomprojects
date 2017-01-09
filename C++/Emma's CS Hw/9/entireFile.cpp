#include <iostream>
using namespace std;

class fraction {
public:
	fraction();
	fraction(int numerator, int denomanator);
	void print() const;
	void simplify();
	fraction addedTo(const fraction &otherF) const;
	fraction subtract(const fraction &otherF) const;
	fraction multipliedBy(const fraction &otherF) const;
	fraction dividedBy(const fraction &otherF) const;
	bool isEqualTo(const fraction &otherF) const;

private:
	int numerator;
	int denominator;
};

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
int main(int argc, const char * argv[]) {
	fraction f1(9, 8);
	fraction f2(2, 3);
	fraction result;
	cout << "The result starts off at ";
	result.print();
	cout << endl;
	cout << "The product of ";
	f1.print();
	cout << " and ";
	f2.print();
	cout << " is ";
	result = f1.multipliedBy(f2);
	result.print();
	cout << endl;
	cout << "The quotient of ";
	f1.print();
	cout << " and ";
	f2.print();
	cout << " is ";
	result = f1.dividedBy(f2);
	result.print();
	cout << endl;
	cout << "The sum of ";
	f1.print();
	cout << " and ";
	f2.print();
	cout << " is ";
	result = f1.addedTo(f2);
	result.print();
	cout << endl;
	cout << "The difference of ";
	f1.print();
	cout << " and ";
	f2.print();
	cout << " is ";
	result = f1.subtract(f2);
	result.print();
	cout << endl;
	if (f1.isEqualTo(f2)) {
		cout << "The two fractions are equal." << endl;
	} else {
		cout << "The two fractions are not equal." << endl;
	}
	const fraction f3(12, 8);
	const fraction f4(202, 303);
	result = f3.multipliedBy(f4);
	cout << "The product of ";
	f3.print();
	cout << " and ";
	f4.print();
	cout << " is ";
	result.print();
	cout << endl;
	return 0;
}
