#include "lab09_headers.h"

// Used in the function createLL()
// This function is given to you correctly - there is no need to change it
static void h_insert(LinkNodePtr& head, string nom, int num)
{
	LinkNodePtr tmp_ptr;
	tmp_ptr = new LinkNode;
	tmp_ptr->name = nom;
	tmp_ptr->number = num;
	tmp_ptr->link = head;
	head = tmp_ptr;
}

static void createLL(LinkNodePtr& h)
{
	// Incomplete function - student must complete
	string nom = "";
	int num;
	while(1)
	{
		// Incomplete code here...
		// At some point, you call:    h_insert(h, nom, num);
		cout << "Enter name, then a number. To quit, enter 0 for the name AND 0 for the number:\n";
		cin >> nom >> num;
		if (nom.compare("0") == 0 && num == 0)
		//quit statement
		{
			break;
		}
		else //inserts nodes
		{
			h_insert(h, nom, num);
		}
	}
}

static void reverseLL(LinkNodePtr& h)
{
	cout << "Reversing the list..." << endl;
	LinkNodePtr prev = NULL;
	LinkNodePtr current = h;
	LinkNodePtr next = NULL;
	while (current != NULL) //reads and reverses list
	{
		next = current->link;
		current->link = prev;
		prev = current;
		current = next;
	}
	h = prev;
}

static void findMax(LinkNodePtr h)
{
	// Incomplete function - student must complete
	int max(0);
	LinkNodePtr tmp = h;
	if (h == NULL) //if list is empty
	{
		cout << "This list is empty." << endl;
		return;
	}
	else
		max = tmp->number;
	while (tmp != NULL) //loop to find max num
	{
		if (tmp->number > max)
			max = tmp->number;
		tmp = tmp->link;
	}
	cout << "Largest number in the list is: " << max << endl;
}

static void findMin(LinkNodePtr h)
{
	// Incomplete function - student must complete
	int min(0);
	LinkNodePtr tmp = h;
	if (h == NULL)
	{
		cout << "This list is empty." << endl;
		return;
	}
	else
		min = tmp->number;
	while (tmp != NULL) //loop to find min
	{
		if (tmp->number < min)
			min = tmp->number;
		tmp = tmp->link;
	}
	cout << "Smallest number in the list is: " << min << endl;
}

static void insertNodeAfter(LinkNodePtr h)
{
	int pos = -1;
	int count = 0;
	LinkNodePtr tmp = h;
	bool is_insert = false;
	string nom;
	if (h == NULL) //if link doesn't exist
	{
		cout << "Cannot insert in a non-existing link." << endl;
		return;
	}
	cout << "Enter node position to insert new node after (enter negative number to exit): ";
	cin >> pos;
	if (pos != -1) //if it's not the exit statement
	{
		while (tmp != NULL) //while it's not empty
		{
			if (count == pos) //if statement to insert nodes
			{
				cout << "Enter data (name, then number): ";
				cin >> nom >> pos;
				LinkNodePtr node;
				node = new LinkNode;
				node->name = nom;
				node->number = pos;
				node->link = tmp->link;
				tmp->link = node;
				is_insert = true;
				break;
			}
			tmp = tmp->link;
			count++;
		}
		if (!is_insert)
			cout << "Position entered is illegal. Nothing inserted." << endl;
	}
}

static void printLL(LinkNodePtr h)
{
	//function to print linked list
	LinkNodePtr tmp = h;
	int count = 0;
	if (tmp == NULL) //if list is empty
	{
		cout << "This list is empty.\n";
		return;
	}
	cout << "Printing the list:\n";
	while (tmp != NULL) //while loop to print if list is not empty
	{
		cout << "Node #" << count << ": " << tmp->name << ", ";
		cout << tmp->number << endl;
		tmp = tmp->link;
		count++;
	}
	cout << "--------" << endl;
}
