
#include <iostream>
using namespace std;

class fraction {
	public:
		void set(int numerator, int denomanator);
		void print();
		fraction addedTo(fraction otherF);
		fraction subtract(fraction otherF);
		fraction multipliedBy(fraction otherF);
		fraction dividedBy(fraction otherF);
		bool isEqualTo(fraction otherF);

	private:
		int numerator;
		int denomanator;
};

void fraction::set(int num, int den) {
	numerator = num;
	denomanator = den;
}

void fraction::print(){
	cout << numerator << "/" << denomanator;
}

fraction fraction::addedTo(fraction otherF) {
	fraction f;
	f.set(numerator, denomanator);
	int num = f.numerator * otherF.denomanator + otherF.numerator * denomanator;
	int den = f.denomanator * otherF.denomanator;
	fraction foo;
	foo.set(num,den);
	return foo;

}

fraction fraction::subtract(fraction otherF) {
	fraction f;
	f.set(numerator, denomanator);
	int num = f.numerator * otherF.denomanator - otherF.numerator * denomanator;
	int den = f.denomanator * otherF.denomanator;
	fraction foo;
	foo.set(num,den);
	return foo;

}

fraction fraction::multipliedBy(fraction otherF) {
	fraction f;
	f.set(numerator, denomanator);
	int num = f.numerator * otherF.numerator;
	int den = f.denomanator * otherF.denomanator;
	fraction foo;
	foo.set(num,den);
	return foo;
}

fraction fraction::dividedBy(fraction otherF) {
	fraction f;
	f.set(numerator, denomanator);
	int num = f.numerator * otherF.denomanator;
	int den = f.denomanator * otherF.numerator;
	fraction foo;
	foo.set(num,den);
	return foo;
}

bool fraction::isEqualTo(fraction otherF) {
	return numerator * otherF.denomanator == denomanator * otherF.numerator;
}
int main(int argc, const char * argv[]) {
	fraction f1;
	fraction f2;
	fraction result;
	f1.set(9, 8);
	f2.set(2, 3);
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
	if (f1.isEqualTo(f2)){
	cout << "The two fractions are equal." << endl;
	} else {
	cout << "The two fractions are not equal." << endl;
	}
    return 0;
}
