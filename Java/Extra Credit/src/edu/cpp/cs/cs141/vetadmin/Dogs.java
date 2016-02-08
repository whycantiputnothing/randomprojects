package edu.cpp.cs.cs141.vetadmin;

import java.util.List;
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

public abstract class Dogs extends Animals {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3646316753455910607L;

	public Dogs(Owner owner, String name, int age, List<MedicalHistory> medicalHistory, List<String> vaccinations,
			List<Appointments> apointments) {
		super(owner, name, age, medicalHistory, vaccinations, apointments);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Dogs";
	}
	
	

}
