package edu.cpp.cs.cs141.vetadmin;

import java.util.List;

public class BettaFish extends Fish {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9021292694239784609L;

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

	public BettaFish(Owner owner, String name, int age, List<MedicalHistory> medicalHistory, List<String> vaccinations,
			List<Appointments> apointments) {
		super(owner, name, age, medicalHistory, vaccinations, apointments);
		// TODO Auto-generated constructor stub
	}
	
	public String getBreed(){
		return "Betta Fish";
	}

}
