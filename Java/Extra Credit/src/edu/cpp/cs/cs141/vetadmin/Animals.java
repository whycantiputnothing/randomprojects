package edu.cpp.cs.cs141.vetadmin;

import java.io.Serializable;
import java.util.List;

public abstract class Animals implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1100953331496294523L;
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

	private Owner owner;
	private String name;
	private int age;
	private static int idCounter = 0;
	private final int id;
	private List<MedicalHistory> medicalHistory;
	private List<String> vaccinations;
	private List<Appointments> apointments;
	
	public Animals(Owner owner, String name, int age, List<MedicalHistory> medicalHistory, List<String> vaccinations,
			List<Appointments> apointments) {
		this.owner = owner;
		this.name = name;
		this.age = age;
		this.medicalHistory = medicalHistory;
		this.vaccinations = vaccinations;
		this.apointments = apointments;
		this.id = idCounter++;
	}
	
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<MedicalHistory> getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(List<MedicalHistory> medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public List<String> getVaccinations() {
		return vaccinations;
	}
	public void setVaccinations(List<String> vaccinations) {
		this.vaccinations = vaccinations;
	}
	public List<Appointments> getApointments() {
		return apointments;
	}
	public void setApointments(List<Appointments> apointments) {
		this.apointments = apointments;
	}
	public String getBreed(){
		return "Animal";
	}
	public int getID(){
		return id;
	}
	
	
}
