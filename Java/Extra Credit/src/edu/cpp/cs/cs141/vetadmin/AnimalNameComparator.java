package edu.cpp.cs.cs141.vetadmin;

import java.util.Comparator;
/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #4
 *
 * <Registry of Vet>
 *
 * Brandon Nguyen
 */

public class AnimalNameComparator implements Comparator<Animals> {

	@Override
	public int compare(Animals a1, Animals a2) {
		// TODO Auto-generated method stub
		return a1.getName().compareTo(a2.getName());
	}
	
}
