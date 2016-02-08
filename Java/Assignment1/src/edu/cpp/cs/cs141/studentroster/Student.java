package edu.cpp.cs.cs141.studentroster;

public class Student {
	/**
	 * 
	 */
	
	private String name;
	/**
	 * 
	 */
	private int id;
	/**
	 * the value of this field ranges from 0 - 100.
	 */
	private int grade;
	
	public Student(String name, int id, int grade){
		this.name = name;
		this.id = id;
		this.grade = grade;
	}
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	

}
