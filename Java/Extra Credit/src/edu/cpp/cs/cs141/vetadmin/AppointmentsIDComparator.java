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

public class AppointmentsIDComparator implements Comparator<Appointments> {

	@Override
	public int compare(Appointments o1, Appointments o2) {
		// TODO Auto-generated method stub
		return o1.getID()-o2.getID();
	}

}
