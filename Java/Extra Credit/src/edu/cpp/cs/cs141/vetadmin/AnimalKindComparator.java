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

public class AnimalKindComparator implements Comparator<Animals> {

	@Override
	public int compare(Animals o1, Animals o2) {
		// TODO Auto-generated method stub
		return o1.toString().compareTo(o2.toString());
	}

}
