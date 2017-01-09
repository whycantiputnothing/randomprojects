
#include <iostream>
#include <iomanip>

int main(int argc, const char * argv[]) {
    int age;
    int zeroTo18 = 0;
    int nineteento30 = 0;
    int thirtyoneto40 = 0;
    int fortyoneto60 = 0;
    int over60 = 0;
    double average = 0;
    int count = 0;
    int youngest;
    int oldest;
    char food;
    int popcorn = 0;
    int soda = 0;
    int both = 0;
	std::cout << "Enter age of attendee (negative number to quit): ";
	std::cin >> age;
	youngest = age;
	oldest = age;
    while (age >= 0) {
    	std::cout << "Enter food of preference ('p' for popcorn, 's' for soda, 'b' for both): ";
    	std::cin >> food;
    	if (food == 'p')
    		++popcorn;
    	else if (food == 's')
    		++soda;
    	else
    		++both;
    	if (age < 19)
    		++zeroTo18;
    	else if (age < 31)
    		++nineteento30;
    	else if (age < 41)
    		++thirtyoneto40;
    	else if (age < 61)
    		++fortyoneto60;
    	else
    		++over60;

    	average = average + age;
    	++count;

    	if (age < youngest)
    		youngest = age;
    	else if( age > oldest)
    		oldest = age;
    	std::cout << "Enter age of attendee (negative number to quit): ";
    	std::cin >> age;
    }
    std::cout << "\n";
    std::cout << "age 0 to 18: " << zeroTo18 << "\n";
    std::cout << "age 19 to 30: " << nineteento30 << "\n";
    std::cout << "age 31 to 40: " << thirtyoneto40 << "\n";
    std::cout << "age 41 to 60: " << fortyoneto60 << "\n";
    std::cout << "over 60: " << over60 << "\n\n";

    std::cout << "food preference popcorn: " << popcorn << "\n";
    std::cout << "food preference soda: " << soda << "\n";
    std::cout << "food preference both: " << both << "\n";
    if (count > 0) {
		average = average/count;
		std::cout << std::fixed;
		std::cout << std::setprecision(1);
		std::cout << "The average age was " << average << "\n";
    }
    else
    	std::cout << "There is no average age as no one was in attendance" << "\n";
    if (youngest >= 0)
    	std::cout << "The youngest person in attendance was " << youngest << "\n";
    else
    	std::cout << "There is not a youngest person as no one was in attendance" << "\n";
    if (oldest >= 0)
    	std::cout << "The oldest person in attendance was " << oldest << "\n";
    else
    	std::cout << "There is not an oldest person as no one was in attendance" << "\n";
    return 0;
}



