package edu.cpp.cs.cs141.vetadmin;

import java.io.Serializable;

public class Appointments implements Serializable{

	private int date;
	private int time;
	private String client;
	private String status;
	private static int idCounter = 0;
	private final int id;
	
	public Appointments(int date, int time, String client) {
			this.date = date;
			this.time = time;
			this.client = client;
			status = "outstanding";
			this.id = idCounter++;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getID() {
		return id;
	}
	
	
}
