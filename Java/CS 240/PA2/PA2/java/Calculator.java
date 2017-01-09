

//Brandon Nguyen
//CS240, Section 02
//Programming Assignment 2
//5/6/2016

 /**

 * COPYRIGHT: smanna@cpp.edu
 * CS 240 Spring 2016
 * Programming Assignment 2
 *
 * STUDENTS SHOULD COMPLETE THIS CODE.
 * You will upload this code to Blackboard.
 *
 * If you do not write enough comments, at least two points
 * will be deducted from your assignment. Also make sure you
 * follow the coding conventions.
 *
 *  Students need to implement a Calculator using the framework provided. Feel
 *  free to add your own fields and methods besides ones already provided. Please do not make
 *  any changes to the provided method signatures. If you do so, your code
 * cannot be run automatically, and you will not be graded.
 *
 *  ** YOUR RESULTS SHOULD BE ROUNDED TO THREE DECIMAL PLACES. IF YOU FAIL TO DO
 *  SO, YOU WILL BE PENALIZED BY 1 POINT.
 *  ** YOU SHOULD PROPOERLY COMMENT YOUR CODE, OTHERWISE YOU WILL BE PENALIZED
 *  BY 5 POINTS.
 *
 **/

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;    
public class Calculator {
// TODO (Student): your fields here

  //Constructor
  public Calculator() {
    // TODO (Student)
  }

  //Constructor with manual debug setting
  public Calculator(boolean DEBUG) {
    // TODO (Student): Optional
  }

  /** Returns true if the new character has precedence to be pushed on to the
  *   stack. Returns false if not.
  *   @param previous operator already on the stack
  *   @param newChar operator being added to the stack
  *   @return boolean of whether the operator has precedence
  */
  private boolean hasPrecedence(Character previous, Character newChar) {
    //if the previous has top precedence then the new doesn't
    if (previous == '*' || previous == '/')
      return false;
    //subtract previous first then new
    else if (previous == '-' && newChar == '-')
      return false;
    //subtract previous then add new
    else if (previous == '-' && newChar == '+')
      return false;
    else {
      return true;
    }
  }

  /** Pops two operands and one operator and performs the operation.
  *   @param operands stack of the operands
  *   @param operators stack of the operators
  *   @return answer to the operation
  */
  private double popStackAndSolve(Stack<Double> operands,Stack<Character>operators) {
    double operand1,operand2,answer;
    char operator;
    operand2 = operands.pop(); //pop the second first because stack ordering
    operand1 = operands.pop();
    operator = operators.pop();
    answer = calc(operand1,operand2,operator);
    return answer;
  }

  /** @param operand1 the first operand in the equation
  *   @param operand2 the second operand in the equation
  *   @param operator the operator to perform on the two operands
  *   @return the answer
  */
  public double calc(double operand1, double operand2, char operator) {
    // TODO (Student)
      double answer = 0.0;
      // checks what kind of operator, then does the operation using operand1 and operand2
      if (operator == '+') {
          answer = operand1 + operand2;
      }
      
      else if (operator == '-') {
          answer = operand1 - operand2;
      }

      else if (operator == '*') {
          answer = operand1 * operand2;
      }    
      
      else if (operator == '/') {
          answer = operand1 / operand2;
      }
    return answer; // fix this
  }

  /** Solves an infix equation and returns the answer as a Double. Limits to 3
  *   decimal places.
  *   @param equation infix String equation to be solved.
  *   @return double answer to equation
  */
  public Double solve(String equation) {
    // TODO (Student)
      Stack<Double> operands = new Stack<Double>();
      Stack<Character> operators = new Stack<Character>();
      // loops over every character in the given String
      for (int i = 0; i < equation.length(); i++) {
          String s = equation.substring(i, i+1);
          // checks if the character is equal to "(" and if it is, then it treats it as the lowest level operator and pushes it to the operator stack
          if (s.equals("("))
              operators.push(s.charAt(0)); 
          
          //if the character is ")" operations are done and their values are pushed back to the operands stack until the "(" is found in the operator stack.
          // then it removes the "("
          else if (s.equals(")")) {
              while (!s.equals("(")) {
                  operands.push(popStackAndSolve(operands, operators));
                  s = operators.peek().toString();
              }
              operators.pop();
          }
          
          //checks for characters that are numbers and adds them to the operands stack
          else if (!(s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-"))) {
                  int j = 0;
                  for(j = i + 1; j < equation.length(); j++) {
                      String s2 = equation.substring(j, j + 1);
                      if (s2.equals(")") || s2.equals("+") || s2.equals("-") || s2.equals("*") || s2.equals("/")) {
                          break;
                      }
                      else 
                          s += s2;
                  }
                  operands.push(Double.parseDouble(s));
                  i = j - 1;
          }
          
          //checks for standard operations and pushes them to the operators stack if it is empty or if it has a higher precedence than the operator
          // at the top of the operator stack. if the operator has a lower precedence than the operator at the top of the stack it pops the operator
          // and pushes the result of the operation back to the operands stack
          else if(s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
              
              while(!operators.empty() && !hasPrecedence(operators.peek(), s.charAt(0))) {
                  operands.push(popStackAndSolve(operands, operators));
              }
              operators.push(s.charAt(0));
          }
          
      }
      //when there are no characters left to read in the String it solves the remaining operations in the operand stack until the stack is empty
      while (!operators.empty()) { 
          operands.push(popStackAndSolve(operands, operators));
      }
      DecimalFormat formatter = new DecimalFormat("#.###");
      return Double.parseDouble(formatter.format(operands.pop())); // fix this
  }
}
