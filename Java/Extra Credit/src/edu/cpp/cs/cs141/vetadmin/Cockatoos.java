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

public class Cockatoos extends Birds {


	/**
	 * 
	 */
	private static final long serialVersionUID = 184534574302545825L;

	public Cockatoos(Owner owner, String name, int age, List<MedicalHistory> medicalHistory, List<String> vaccinations,
			List<Appointments> apointments) {
		super(owner, name, age, medicalHistory, vaccinations, apointments);
		// TODO Auto-generated constructor stub
	}
	
	public String getBreed(){
		return "Cockatoos";
	}

}
