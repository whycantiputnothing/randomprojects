package edu.cpp.cs.cs141.vetadmin;

import java.util.ArrayList;
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

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UI ui = new UI(new AdminEngine());
		ui.start();
		/*
		AdminEngine ae = new AdminEngine();
		Owner o = new Owner("Brandon", null, null);
		Owner o1 = new Owner("Dylan", null, null);
		Owner o2 = new Owner("Justin", null, null);
		Appointments appointment = new Appointments(100, 114, "Brandon");
		Appointments appointment2 = new Appointments(100, 112, "Dylan");
		Appointments appointment3 = new Appointments(1, 1, "Brandon");
		Appointments appointment4 = new Appointments(12, 112, "Justin");
		List<Appointments> l = new ArrayList<Appointments>();
		l.add(appointment);
		List<Appointments> l2 = new ArrayList<Appointments>();
		l2.add(appointment2);
		List<Appointments> l3 = new ArrayList<Appointments>();
		l3.add(appointment4);
		l3.add(appointment3);
		
		MedicalHistory mh = new MedicalHistory("Aids", true);
		MedicalHistory mh1 = new MedicalHistory("Raibes", false);
		MedicalHistory mh3 = new MedicalHistory("Aids", false);
		MedicalHistory mh2 = new MedicalHistory("Raibes", true);
		
		List<MedicalHistory> ml = new ArrayList<MedicalHistory>();
		ml.add(mh);
		ml.add(mh1);
		ml.add(mh2);
		List<MedicalHistory> ml2 = new ArrayList<MedicalHistory>();
		ml2.add(mh);
		List<MedicalHistory> ml3 = new ArrayList<MedicalHistory>();
		ml3.add(mh);
		ml3.add(mh1);
		ml3.add(mh3);
		
//		Animals z = new GermanShepards(Owner, Name, Age, medicalHistory, vaccinations, apointments)
		Animals a = new GermanShepards(o, "Spike", 13, ml, null, l);
		Animals b = new BettaFish(o1, "Alpha", 2, ml2, null, l2);
		Animals c = new Parakeets(o1, "Fluffy", 3, ml3, null, l3);
		Animals z = new Samoyeds(o2, "Doge", 13, ml, null, l);
	
		ae.addAnimal(a);
		ae.addAnimal(b);
		ae.addAnimal(c);
		ae.addAnimal(a);
		System.out.println(ae.animals());
		ae.load("save");
		System.out.println(ae.animals());
		System.out.println("hi");
//		ae.sortAnimalName();

		
		
		/*		
		ae.fillAppointments();
		System.out.println(ae.appointments());
		ae.searchAppointmentsClient("Brandon");
		System.out.println(ae.appointmentsTemp());
		ae.searchAppointmentsDate(100);
		System.out.println(ae.appointmentsTemp());
		
		ae.searchMedicalByName("Spike");
		System.out.println(ae.medicalHistory());
		
		ae.searchMedicalByOwner("Dylan");
		System.out.println(ae.medicalHistory());
		
		ae.searchMedicalByKind("Dogs");
		System.out.println(ae.medicalHistory());
		
		ae.save("save");
		/*	
		ae.changeAppointmentStatus(0);
		ae.removeAppointment();
		ae.fillAppointments();
		System.out.println(ae.appointments());
*/
	}
	

}
