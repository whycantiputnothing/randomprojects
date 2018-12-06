#include <iostream>
#include <iomanip>

using namespace std;
void make_histogram(int *hist, int max) {
	for(i=0; i<=max; i++)
	{
		int no=0;
		for(int j=0; j<numGrades; j++)
		{
			if(i==list[j])
				no++;
		}
		hist[i]=no;
	}
}
void print_histogram(int *hist, int max){
	cout << "Histogram:" << endl;
	for(int i=0; i<=max; i++)
	{
		if((hist[i]) !=0)
		{
			cout << right << setw(3) << i << " ";
			for(int j=0; j<hist[i]; j++)
				cout << "*";
		}
		if((hist[i]) != 0)
			cout << endl;
	}
}

int main()
{
	int numGrades;
	int i,j;
	int max = 0;
	int *list, *hist;
	cout << "Enter number of grades:" << endl;
	cin >> numGrades;
	list = new int[numGrades];
	cout << "Enter grades (each on a new line):\n";
	for(i=0; i<numGrades; i++)
	{
		cin >> list[i];
	}
	for(i=0; i<numGrades; i++)
	{
		if(max<list[i])
			max =list[i];
	}
	hist = new int[max];
	for(i=0; i<=max; i++)
	{
		int no=0;
		for(int j=0; j<numGrades; j++)
		{
			if(i==list[j])
				no++;
		}
		hist[i]=no;
	}
	print_histogram(hist, max);
	delete []hist;
	delete []list;
	return 0;
}
