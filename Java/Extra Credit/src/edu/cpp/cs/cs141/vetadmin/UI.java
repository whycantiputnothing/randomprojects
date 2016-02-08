package edu.cpp.cs.cs141.vetadmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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


public class UI {
	private AdminEngine ae = null;
	private Scanner in = null;
	private int option;
	private boolean bool;
	
	public UI(AdminEngine adminEngine) {
		ae = adminEngine;
		in = new Scanner(System.in);
	}
	
	/**
	 * starts the service, prompts the user what registry they what to load along with
	 * what they want to do to start
	 */
	public void start(){
		load();
		bool = true;
		while(bool) {
			System.out.println("What would you like to do? \n" + "\t1. Access Animals\n" + "\t2. List Appointments\n" + "\t3. List Medical Records\n" 
					 + "\t4. Save\n"  + "\t5. Exit");
			while (true) {
				try {
					in = new Scanner(System.in);
					option = in.nextInt();
					in.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a number from 1 - 3");
				}
			}
			
			if (option == 1) {
				accessAnimals();
			}
			else if(option == 2){
				listAppointments();
			}
			else if (option == 3) {
				listMedicalRecords();
			}
			else if (option == 4) {
				save();
			}
			else if (option == 5) {
				System.exit(0);
			}
			
		}
	}
	
	/**
	 * allows the user to search medical records by name, owner, or animal kind
	 */
	private void listMedicalRecords() {
		System.out.println("What would you like to do? \n" + "\t1. Search by name\n" + "\t2. Search by owner\n" + "\t3. Search by animal kind" );
		while (true) {
			try {
				in = new Scanner(System.in);
				option = in.nextInt();
				in.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number from 1 - 3");
			}
		}
		ae.fillTempAnimals();
		if (option == 1) {
			System.out.println("What is the name of the animal?");
			String name = "";
			while (true) {
				try {
					in = new Scanner(System.in);
					name = in.nextLine();
					
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a number from 1 - 3");
				}
			}
			
			ae.searchMedicalByName(name);
			System.out.println(ae.medicalHistory());
			System.out.println("press any key to return to the main menu");
			in.nextLine();
		}
		else if(option == 2){
			System.out.println("What is the name of the owner?");
			String name = "";
			while (true) {
				try {
					in = new Scanner(System.in);
					name = in.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a number from 1 - 3");
				}
			}
			ae.searchMedicalByOwner(name);
			System.out.println(ae.medicalHistory());
			System.out.println("press any key to return to the main menu");
			in.nextLine();
		}
		else if (option == 3) {
			System.out.println("What is the kind of the animal?");
			String name = "";
			while (true) {
				try {
					in = new Scanner(System.in);
					name = in.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a number from 1 - 3");
				}
			}
			ae.searchMedicalByKind(name);
			System.out.println(ae.medicalHistory());
			System.out.println("press any key to return to the main menu");
			in.nextLine();
		}
	}

	/**
	 * allows to the user to see appointments by owner, date, or listing all of them
	 * the user can also change the status of any appointment 
	 */
	private void listAppointments() {
		System.out.println("What would you like to do? \n" + "\t1. List all appointments\n" + "\t2. Search by owner\n" + "\t3. Search by date");
		while (true) {
			try {
				in = new Scanner(System.in);
				option = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number from 1 - 3");
			}
		
		}
		
		ae.fillAppointments();
		
		if (option == 1) {
			ae.fillAppointments();
			System.out.println(ae.appointments());
			System.out.println("Press 1 to change the status of an appointment or 2 to go back to the main menu");
			while (true) {
				try {
					in = new Scanner(System.in);
					option = in.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter 1 or 2");
				}
			}
			if (option == 1 ) {
				System.out.println("Which appoitnment# status would u like to change");
				int appointmentID = 0;
				while (true) {
					try {
						in = new Scanner(System.in);
						option = in.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Please enter numbers only");
					}
				}
				ae.changeAppointmentStatus(appointmentID);
				ae.removeAppointment();
			}
		}
		else if (option == 2) {
			System.out.println("What is the name of the owner?");
			String client = "";
			while (true) {
				try {
					in = new Scanner(System.in);
					client = in.nextLine();
					
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter only letters");
				}
			}
			ae.searchAppointmentsClient(client);
			System.out.println(ae.appointmentsTemp());
			System.out.println("(1) Change appointment status (2) Go to the main menu");
			while (true) {
				try {
					in = new Scanner(System.in);
					option = in.nextInt();
					
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter 1 or 2");
				}
			}
			if (option == 1) {
				int appointmentID = 0;
				System.out.println("What appointment# would u like to change");
				while (true) {
					try {
						in = new Scanner(System.in);
						option = in.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Please enter numbers only");
					}
				}
				ae.changeAppointmentStatus(appointmentID);
				ae.removeAppointment();
				
				
			}
		}
		else if (option == 3) {
			System.out.println("What is the date you would like to search?");
			while (true) {
				try {
					in = new Scanner(System.in);
					option = in.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter numbers only");
				}
			}
			ae.searchAppointmentsDate(option);
			System.out.println(ae.appointmentsTemp());
			System.out.println("(1) Change appointment status (2) Go to the main menu");
			while (true) {
				try {
					in = new Scanner(System.in);
					option = in.nextInt();
					
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter 1 or 2");
				}
			}
			if (option == 1) {
				int appointmentID = 0;
				System.out.println("What appointment# would u like to change");
				while (true) {
					try {
						in = new Scanner(System.in);
						option = in.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Please enter numbers only");
					}
				}
				ae.changeAppointmentStatus(appointmentID);
				ae.removeAppointment();
				
				
			}
		}
	}

	/**
	 * allows the user to see a list of all the animals on record along with access a certain animal 
	 * and see its appointments along with add appointments
	 */
	private void accessAnimals() {
		System.out.println("Would you like to... \n" + "\t1. Print all animals\n" + "\t2. Go Back" );
		while (true) {
			try {
				in = new Scanner(System.in);
				option = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number from 1 - 2");
			}
		}
		
		if (option == 1) {
			System.out.println(ae.animals());
			System.out.println("Which animal record would you like to access?");
			int ID = 0;
			while (true) {
				try {
					in = new Scanner(System.in);
					ID = in.nextInt();
					in.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter an integer");
				}
			}
			ae.singleRecord(ID);
			System.out.println(ae.animalsTemp());
			ae.checkAppointments(ID);
			System.out.println(ae.appointmentsTemp());
			bool = true;
			while (bool) {
				
				System.out.println("What would you like to do? \n" + "\t1. Make an appointment\n" + "\t2. Go back to the main menu");
				while (true) {
					try {
						in = new Scanner(System.in);
						option = in.nextInt();
						in.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Please enter either 1 or 2");
					}
				}
				if (option == 1) {
					System.out.println("Please enter a date in 'YYYYMMDD' format");
					int date = 0;
					while (true) {
						try {
							in = new Scanner(System.in);
							date = in.nextInt();
							in.nextLine();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Please enter the date in YYYYMMDD format");
						}
					}
					System.out.println("a time for the appointment in military time");
					int time = 0;
					while (true) {
						try {
							in = new Scanner(System.in);
							option = in.nextInt();
							in.nextLine();
							break;
						} catch (InputMismatchException e) {
							System.out.println("please only enter numbers");
						}
					}
					ae.makeAppointment(ID, date, time);
				}
				else
					bool = false;
			}
		}
		
	}

	/**
	 * saves the file. does error checking with the file ending
	 */
	private void save() {
		System.out.println("What would you like to save the registry as");
		String str = in.nextLine();
		if (!(str.endsWith(".dat")))
			str += ".dat";
		try {
			FileOutputStream fos = new FileOutputStream(str);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ae);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * loads a file. lists the files in the directory and does error checking for file ending 
	 */
	private void load() {
		System.out.println("What file would you like to load?");
		File directory = new File(System.getProperty("user.dir"));

		// get all the files from a directory
		File[] fList = directory.listFiles();
		List<File> files = new ArrayList<File>();
		for (File file : fList) {
			if (file.getName().toLowerCase().endsWith(".dat")) {
				files.add(file);
			}
		}

		for (File file : files) {
			System.out.println(file.getName());
		}

		String str = in.nextLine();
		if (!(str.endsWith(".dat"))) {
			str += ".dat";
		}
		
		try {
			FileInputStream fis = new FileInputStream(str);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ae = (AdminEngine)ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void addanimals(){
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
	
	}
}