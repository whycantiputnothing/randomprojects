#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

struct LinkNode
{
	string name;
	int number;
	LinkNode *link;
};

typedef LinkNode* LinkNodePtr;

// Please note the use of static type here. Don't worry about its general use.
// For this project, we are using it to aid in easier compilation of the multiple files.
// There is no need to delve into it any further than that...
static void h_insert(LinkNodePtr& head, string nom, int num);
static void printLL(LinkNodePtr h);
static void createLL(LinkNodePtr& h);
static void reverseLL(LinkNodePtr& h);
static void findMax(LinkNodePtr h);
static void findMin(LinkNodePtr h);
static void insertNodeAfter(LinkNodePtr h);
