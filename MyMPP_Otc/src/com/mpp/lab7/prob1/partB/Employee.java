package com.mpp.lab7.prob1.partB;

public class Employee {
	private String name;
	private int salary;
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override 
	public String toString() {
		return "(" + name + ", " + salary + ")";
	}
	
	/*public boolean equals(Employee e) {
		return e.name.equals(name) && e.salary == salary;
	}*/
	
	@Override
	public boolean equals(Object e) {
		if(null == e)
			return false;
		if(e.getClass() != getClass())
			return false;
		Employee other = (Employee) e;
		return other.name.equals(name) && other.salary == salary;
	}
	
}
