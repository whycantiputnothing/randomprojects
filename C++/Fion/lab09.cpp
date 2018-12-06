#include "lab09_functions.cpp"

int main()
{
	// Define the node and its pointer type
	// Actual node structure defined in lab09_headers.h
	LinkNode node;
	LinkNodePtr head = NULL;

	//1 and 2. Create a linked list of variable length and then print it.
	createLL(head);
	printLL(head);

	//3 and 4. Reverse this linked list and then print it.
	reverseLL(head);
	printLL(head);

	//5 and 6. Insert a node inside this linked list, based on a position number
	insertNodeAfter(head);
	printLL(head);

	// 7 and 8. Find and print the largest, and then the smallest, number in the linked list data
	findMax(head);
	findMin(head);

	return 0;
}
