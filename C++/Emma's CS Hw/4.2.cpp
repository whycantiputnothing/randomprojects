
#include <iostream>

int main(int argc, const char * argv[]) {
    int pounds;
	std::cout << "enter pounds (negative number to quit): ";
	std::cin >> pounds;
    while (pounds >= 0) {
		int ounces;
		ounces = 16*pounds;
		std::cout << pounds
				  << " pounds is "
				  << ounces
				  << " ounces.\n";
		std::cout << "enter pounds (negative number to quit): ";
		std::cin >> pounds;
    }
    return 0;
}


