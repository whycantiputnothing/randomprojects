#include <iostream>
#include <string>
using namespace std;

struct Node
{
	int data;
	Node *link;
};

typedef Node* NodePtr;
void head_insert(NodePtr& head, int the_number);
void printLL(NodePtr h);

// searchLL returns a new pointer to the node where the target value is
NodePtr searchLL(NodePtr h, int target);



int main()
{
	NodePtr head;
	head = new Node;

	head->data = 3;
	head->link = NULL;

	head_insert(head, 5);
	head_insert(head, 4);
	head_insert(head, 3);
	head_insert(head, 2);
	head_insert(head, 1);
	head_insert(head, 0);

	printLL(head);

	NodePtr myPointer;
	myPointer = searchLL(head, 4);

	if (myPointer != NULL)
	{
		cout << "I found it! It's address is " << myPointer;
		cout << " and the value there is " << myPointer->data << endl;
	}
	else
		cout << "I didn't find it!\n";

	return 0;
}

void head_insert(NodePtr& head, int the_number)
{
	NodePtr temp_ptr;
	temp_ptr = new Node;

	temp_ptr->data = the_number;

	temp_ptr->link = head;
	head = temp_ptr;

}

void printLL(NodePtr h)
{
	NodePtr tmp = h;

	if (tmp == NULL)
	{
		cout << "This list is empty.\n";
		return;
	}

	cout << "Printing the list:\n";
	while (tmp != NULL)
	{
		cout << tmp->data << endl;
		tmp = tmp->link;
	}
	cout << endl;
}


NodePtr searchLL(NodePtr h, int target)
{
	NodePtr here = h;

	// If it's an empty LL...
	if (here == NULL)
		return NULL;

	// If it's not an empty LL, then...
	//
	// STUDENTS - COMPLETE THIS PART!
	while(here != NULL) {
		if(here->data == target)
			return here;
		else
			here = here->link;
	}
}
