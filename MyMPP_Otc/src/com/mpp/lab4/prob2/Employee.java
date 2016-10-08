package com.mpp.lab4.prob2;

import java.time.LocalDate;

public abstract class Employee {
	String empId;
	PayCheck payCheck;
	protected final int WEEKPERWEEK = 4;
	
	public void  print(){
		payCheck = calCompensation(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
		
		System.out.println(payCheck.print());
	}
	
	public PayCheck calCompensation(int month, int year) {
		Double grossPay = calGrossPay(month, year);
		PayCheck paycheck = new PayCheck(grossPay);
		return paycheck;
	}
	
	abstract double calGrossPay(int month, int year);
}
