package com.test.test.Person;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	 private int id;
		private String name;
	    private double salary;
	    private String address;

	    // Constructor to initialize a Person object
	    public Person(String name, int id, double salary, String address) {
	        this.name = name;
	        this.id = id;
	        this.salary = salary;
	        this.address = address;
	    }

	    
	    public void setId(int id) {
			this.id = id;
		}


		public void setName(String name) {
			this.name = name;
		}


		public void setSalary(double salary) {
			this.salary = salary;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		// Getter methods for each field
	    public String getName() {
	        return name;
	    }

	    public int getId() {
	        return id;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public String getAddress() {
	        return address;
	    }

	    // Override toString() for easy printing of Person objects
	    @Override
	    public String toString() {
	        return "Person [ID=" + id + ", Name=" + name + ", Salary=" + salary + ", Address=" + address + "]";
	    }

	


}
