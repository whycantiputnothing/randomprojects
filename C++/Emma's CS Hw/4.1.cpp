
#include <iostream>

int main(int argc, const char * argv[]) {
    int pounds;
    char response;

    std::cout << "Is there a conversion to be made (Y/N)? ";
    std::cin >> response;
    while (response == 'Y') {
		std::cout << "enter pounds: ";
		std::cin >> pounds;
		int ounces;
		ounces = 16*pounds;
		std::cout << pounds
				  << " pounds is "
				  << ounces
				  << " ounces.\n";
    	std::cout << "Is there another conversion to be made (Y/N)? ";
    	std::cin >> response;
    }
    return 0;
}

