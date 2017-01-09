#ifndef FRACTION_H
#define FRACTION_H


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

#endif