

 /**
 * COPYRIGHT: smanna@cpp.edu
 * CS 240 Spring 2016
 * Programming Assignment 1
 *
 * STUDENTS SHOULD COMPLETE THIS CODE.
 * You will upload this code to Blackboard.
 *
 * Feel free to include your own utility private fields and methods.
 * But please make sure you do not change the signature
 * of the public methods provided. If you do so, your code
 * cannot be run automatically, and you will not be graded.
 *
 * If you do not write enough comments, at least two points
 * will be deducted from your assignment. Also make sure you
 * follow the coding conventions.
 *
 * Make sure you check all the boundary conditions while implementing
 * your code here.
 *
 **/
public class LinkedList {
    public static void main (String[] args) {
        LinkedList l1 = new LinkedList();
        l1.prepend(2);
        l1.prepend(1);
        l1.prepend(0);
        l1.deleteElemAt(0);
        System.out.println(l1.toString());
    }
//TODO(Student): put your private fields here
    private Node head; 
  // constructor
  public LinkedList() {
    // TODO (Student): do the necessary changes here
      head = null;    //defaults the head to null when a linkedlist is created
  }

  //adds element to end of the list
  public void append(int elem) {
    // TODO (student):
      Node newNode = new Node(elem);    // creates a node with elem as its data 
      if (head == null) {               // if the LL is empty then it sets the head to newNode
          head = newNode;
      }
      else {                            // if the LL is not empty then it traverses the LL until the tail then sets the tail's next node to newNode
          Node cursor = head; 
          while (cursor.next != null) {
              cursor = cursor.next;
          }
          cursor.next = newNode;
      }
  }

  //adds element to the beginning of the list
  public void prepend(int elem) {
    // TODO (student)
      head = new Node(elem, head);    // sets the head to a Node containing elem as its data and the old head as it's next node
  }

  // Post insert, element should be at a given index. Index is 0-
  // based. That means, insert(0, 5) is equivalent to prepend(5)
  public void insert(int index, int elem) {
    // TODO (student)
      Node cursor = head;     // creates a cursor that points to head
      if (index == 0) {       // if the index is equal to 0, it uses prepend to insert at index 0
          prepend(elem);
      }
      else {                  // if the index is not 0, it loops until the inputed index, creates a new Node with elem as its data
                              // and then sets the newNode's next node as the cursor's next node and setting cursor's next node as the
                              // new node
          for (int i = 0; i < index; i++) {
              cursor = cursor.next;
          }
          Node newNode = new Node(elem, cursor.next);
          cursor.next = newNode;          
      }
  }

  //deletes element at index i(0-based)
  public void deleteElemAt(int i) {
    // TODO (student)
      Node cursor = head;
      if (i == 0) {   //if the intended index is the head it sets the head to the next node
          head = head.next;
      }
      else {    // if the index is not 0, it loops to the node before the intended index and sets its next node to the 
                // node that is two away from it
          for(int j = 0; j < i - 1; j++) {
              cursor = cursor.next;
          }
          cursor.next = cursor.next.next;          
      }
  }

  //returns the index of the element found; return -1 if not found
  public int findElem(int elem) {
    // TODO (student)
      Node cursor = head;
      int counter = 0;
      while (cursor != null) {  // loops through the entire LL and checks each node's data to see if it is equal to elem
          if (cursor.getData() == elem) {
              return counter;
          }
          counter++;
          cursor = cursor.next;
      }
    return -1; // make sure you change this
  }

  //returns element at index i; return -1 if not found
  public int readElemAt(int i) {
    // TODO (student)
      int counter = 0;
      Node cursor = head;
      while (cursor != null) {    // loops until index i if it exists and returns the value of the node's data
          if(counter == i) {
              return cursor.getData();
          }
          cursor = cursor.next;
      }
    return -1 ; // make sure you chage this
  }

  //returns space separated list of elements such as "1 3 5 2".
  //For empty list it should return ""
  public String toString() {
    // TODO (student)
      String str = "";
      Node cursor = head;
      while (cursor != null) {    // loops through the entire LL and adds each node's data to String str with a space in-between.
          str += " " + cursor.getData();
          cursor = cursor.next;
      }
    
    return str.trim(); // make sure you change this
    // to trim the leading whitespace .trim() is used
  }


  // Defining node here
  // begin: node class
  //  WARNING: DO NOT MAKE ANY CHANGES TO THE NODE CLASS
  public class Node {
    private int data;
    private Node next;


    //for elements that are at the tail
    public Node(int data) {
      this.data=data;
      next=null;
    }

    //for everything else
    public Node(int data, Node next) {
      this.data=data;
      this.next=next;
    }

    public int getData() {
      return data;
    }
  } // end: node class
}
