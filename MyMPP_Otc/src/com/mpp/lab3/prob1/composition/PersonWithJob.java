package com.mpp.lab3.prob1.composition;

public class PersonWithJob {
	
	private double salary;
	Person person;
	public double getSalary() {
		return salary;
	}

	PersonWithJob(String n, double s) {
		salary = s;
		person = new Person(n);
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPerson;
		boolean isEqual = this.getSalary()==p.getSalary() && this.person.equals(aPerson);
		return isEqual;
	}
	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		PersonWithJob p2 = new PersonWithJob("Joe", 30000);
		//As PersonsWithJobs, p1 should be equal to p2 
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}


}
