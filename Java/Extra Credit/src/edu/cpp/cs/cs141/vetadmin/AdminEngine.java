package edu.cpp.cs.cs141.vetadmin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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


public class AdminEngine implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2967939319812353342L;
	private List<Animals> animalList = new ArrayList<Animals>();
	private List<Appointments> appointmentsList = new ArrayList<Appointments>();
	private List<Appointments> tempAppointmentsList;
	private List<Animals> tempAnimalList;

	public void fillAppointments() {
		List<Appointments> tempAppointments = new ArrayList<Appointments>();
		for (Animals a : animalList) {
			for (Appointments b : a.getApointments()) {
				tempAppointments.add(b);
			}
		}
		appointmentsList = tempAppointments;
	}
	
	public void fillTempAnimals() {
		tempAnimalList = animalList;
	}

	public void addAnimal(Animals a) {
		animalList.add(a);
	}

	public void sortAnimalName() {
		Collections.sort(animalList, new AnimalNameComparator());
	}

	/**
	 * @param date of the appointment to be searched
	 * searches through the array of appointments and sets the tempappointments
	 * to those with the date 
	 */
	public void searchAppointmentsDate(int date) {
		for (Appointments a : appointmentsList) {
			System.out.println(a.getDate());
		}
		System.out.println();

		Collections.sort(appointmentsList, new AppointmentsDateComparator());

		for (Appointments a : appointmentsList) {
			System.out.println(a.getDate());
		}
		System.out.println();

		int index = Collections.binarySearch(appointmentsList, new Appointments(date, 0, null),
				new AppointmentsDateComparator());
		int startI = 0;
		int endI = 0;
		if (index == 0) {
			startI = 0;
		} else {
			for (int i = index; i > 0; i--) {
				if (!(appointmentsList.get(i).getDate() == date)) {
					startI = i + 1;
					break;
				}
			}
		}
		if (index == appointmentsList.size() - 1) {
			endI = appointmentsList.size();
		} else {
			for (int j = index; j < appointmentsList.size(); j++) {
				if (!(appointmentsList.get(j).getDate() == date)) {
					endI = j;
					break;
				}
			}
			if (endI == 0) {
				endI = appointmentsList.size();
			}
		}
		tempAppointmentsList = appointmentsList.subList(startI, endI);
	}

	/**
	 * @param client name to be searched for
	 * seraches through the array for appointments with the client and adds them to
	 * temp appointments
	 * 
	 */
	public void searchAppointmentsClient(String client) {
		Collections.sort(appointmentsList, new AppointmentsClientComparator());
		
		int index = Collections.binarySearch(appointmentsList, new Appointments(0, 0, client),
				new AppointmentsClientComparator());
		int startI = 0;
		int endI = 0;
		if (index == 0) {
			startI = 0;
		} else {
			for (int i = index; i > 0; i--) {
				if (!(appointmentsList.get(i).getClient().equals(client))) {
					startI = i + 1;
					break;
				}
			}
		}
		if (index == appointmentsList.size() - 1) {
			endI = appointmentsList.size();
		} else {
			for (int j = index; j < appointmentsList.size(); j++) {
				if (!(appointmentsList.get(j).getClient().equals(client))) {
					endI = j;
					break;
				}
			}
			if (endI == 0) {
				endI = appointmentsList.size();
			}
		}
		tempAppointmentsList = appointmentsList.subList(startI, endI);
	}

	/**
	 * removes appointment if its status is resolved
	 */
	public void removeAppointment() {
		for (Animals a : animalList) {
			List<Appointments> b = a.getApointments();
			for (int i = 0; i < b.size(); i++) {
				if (b.get(i).getStatus() == "resolved") {
					b.remove(i);
				}
			}
			a.setApointments(b);
		}
	}

	/**
	 * @param appointmentID
	 * changes an appointment with ID to resolved
	 */
	public void changeAppointmentStatus(int appointmentID) {
		for (Animals a : animalList) {
			for (Appointments b : a.getApointments()) {
				if (b.getID() == appointmentID) {
					b.setStatus("resolved");
				}
			}
		}
	}
	
	/**
	 * @param name
	 * searches through the array for medical histories belonging to 
	 * aniamls with the passed name
	 */
	public void searchMedicalByName(String name) {
		Collections.sort(animalList, new AnimalNameComparator());
		Animals b = new Animals(null, name, 0, null, null, null) {
		};
		
		int index = Collections.binarySearch(animalList, b , new AnimalNameComparator());
		int startI = 0;
		int endI = 0;
		if (index == 0) {
			startI = 0;
		} else {
			for (int i = index; i > 0; i--) {
				if (!(animalList.get(i).getName().equals(name))) {
					startI = i + 1;
					break;
				}
			}
		}
		if (index == animalList.size() - 1) {
			endI = animalList.size();
		} else {
			for (int j = index; j < animalList.size(); j++) {
				if (!(animalList.get(j).getName().equals(name))) {
					endI = j;
					break;
				}
			}
			if (endI == 0) {
				endI = animalList.size();
			}
		}
		tempAnimalList = animalList.subList(startI, endI);
			
	}
	
	/**
	 * @param Owner
	 * adds medicalhistories from animals of a certain owner to the temp animal list
	 */
	public void searchMedicalByOwner(String Owner) {
		Collections.sort(animalList, new AnimalOwnerComparator());
		List<Animals> ta = new ArrayList<Animals>();
		for (Animals a: animalList){
			if(a.getOwner().getName().equals(Owner)){
				ta.add(a);
			}
		}
		tempAnimalList = ta;
			
	}
	
	public void searchMedicalByKind(String kind) {
		Collections.sort(animalList, new AnimalKindComparator());
		List<Animals> ta = new ArrayList<Animals>();
		for (Animals a: animalList){
			if(a.toString().equals(kind)){
				ta.add(a);
			}
		}
		tempAnimalList = ta;
			
	}
	
	/**
	 * @param ID
	 * allows printing of appointments of a certain animal
	 */
	public void checkAppointments(int ID) {
		for(Animals a : animalList) {
			if(a.getID() == ID){
				tempAppointmentsList = a.getApointments();
			}
		}
	}
	
	/**
	 * @param ID of animal to make appointment for
	 * @param date of appointment
	 * @param time of appointment
	 */
	public void makeAppointment(int ID, int date, int time) {
		for(Animals a : animalList) {
			if(a.getID() == ID){
				Appointments b = new Appointments(date, time, a.getOwner().getName());
				a.getApointments().add(b);
			}
		}
	}	
	
	/**
	 * @param id of animal to be displayed
	 */
	public void singleRecord(int id) {
		List<Animals> ta = new ArrayList<Animals>();
		for (Animals a: animalList){
			if (a.getID() == id) {
				ta.add(a);
			}
		}
		tempAnimalList = ta;
	}

	public String appointments() {
		String s = "";
		for (Appointments a : appointmentsList) {
			s += "Appointment#: " + a.getID() + "| Client: " + a.getClient() + "| Date: " + a.getDate() + "| Time: "
					+ a.getTime();
			s += "\n";
		}
		return s;
	}

	public String appointmentsTemp() {
		String s = "";
		for (Appointments a : tempAppointmentsList) {
			s += "Appointment#: " + a.getID() + "| Client: " + a.getClient() + "| Date: " + a.getDate() + "| Time: "
					+ a.getTime();
			s += "\n";
		}
		return s;
	}

	public String animals() {
		String s = "";
		for (Animals a : animalList) {
			s += "Animal#: " + a.getID() + "| Owner: " + a.getOwner().getName() + "| Name: " + a.getName()
					+ "| Animal Kind: " + a.getBreed();
			s += "\n";
		}
		return s;
	}
	
	public String animalsTemp() {
		String s = "";
		for (Animals a : tempAnimalList) {
			s += "Animal#: " + a.getID() + "| Owner: " + a.getOwner().getName() + "| Name: " + a.getName()
					+ "| Animal Kind: " + a.getBreed();
			s += "\n";
		}
		return s;
	}
	
	public String medicalHistory() {
		String s = "";
		for (Animals a : tempAnimalList) {
			s += "Animal#: " + a.getID() + "| Owner: " + a.getOwner().getName() + "| Name: " + a.getName()
					+ "| Animal Kind: " + a.getBreed();
			s += "\n";
			for (MedicalHistory b : a.getMedicalHistory()){
				String str = "past";
				if (b.getStatus())
					str = "current";
				s += "\t" + "Disease: " + b.getDiseases() + "| Status: " + str;
				s += "\n";
			}
			s += "\n";
		}
		return s;
	}
}
