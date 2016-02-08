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

public class OwnerComparator implements Comparator<Owner>{

	@Override
	public int compare(Owner o1, Owner o2) {
		// TODO Auto-generated method stub
		return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
	}

}
