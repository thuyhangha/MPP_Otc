package com.mpp.lab4.prob2;

public class Salary extends Employee{
	private double salary = 0.0;

	public Salary(double salary) {
		// TODO Auto-generated constructor stub
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	double calGrossPay(int month, int year) {
		// TODO Auto-generated method stub
		return this.salary * this.WEEKPERWEEK;
	}
}
