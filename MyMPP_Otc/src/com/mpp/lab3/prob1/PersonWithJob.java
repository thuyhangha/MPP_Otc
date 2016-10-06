package com.mpp.lab3.prob1;

public class PersonWithJob extends Person {
	
	private double salary;
	
	public double getSalary() {
		return salary;
	}
	PersonWithJob(String n, double s) {
		super(n);
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPerson;
		boolean isEqual = this.getName().equals(p.getName()) &&
				this.getSalary()==p.getSalary();
		return isEqual;
	}
	public static void main(String[] args) {
		Person p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		//As PersonsWithJobs, p1 should be equal to p2
		//P2 is not instance  of PersonWithJob, P2 is superclass (Person) of PersonWithJob. Person is not a PersonWithJob. Thus it can not equal and return false.  
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		
		//p1: PersonalWithJob is sub class of person. PersonWithJob is a Person. Thus, the result is true. 
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
		
		//The root cause becausue of inheritance. The subclass can be a super class but the super class can not. We should replace inheritance  with composition to solve that issue.
	}


}
