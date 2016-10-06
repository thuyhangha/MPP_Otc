package com.mpp.lab4.prob2;

public class Hourly extends Employee{
	int hourlyWage = 0;
	int hoursPerWeek = 0;
	
	public Hourly(int hourlyWage, int hoursPerWeek) {
		// TODO Auto-generated constructor stub
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}
	
	@Override
	double calGrossPay(int month, int year) {
		// TODO Auto-generated method stub
		return this.hourlyWage * this.hoursPerWeek * this.WEEKPERWEEK;
	}
	
}
