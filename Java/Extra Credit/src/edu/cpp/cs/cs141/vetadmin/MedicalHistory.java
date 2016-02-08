package edu.cpp.cs.cs141.vetadmin;

import java.io.Serializable;
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

public class MedicalHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 663482801139373918L;
	private String diseases;
	private boolean status;
	
	public MedicalHistory(String diseases, boolean status) {
		this.setDiseases(diseases);
		this.setStatus(status);
	}

	public String getDiseases() {
		return diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	


}
