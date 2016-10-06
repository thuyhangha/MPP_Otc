package com.mpp.lab4.prob2;

public final class PayCheck {
	private double grossPay;
	private static final double fica = 0.23;  
	private static final double state = 0.05;  
	private static final double local = 0.01;  
	private static final double medicare = 0.03;  
	private static final double socialSercurity = 0.075;  
	
	public PayCheck(double grossPay) {
		// TODO Auto-generated constructor stub
		this.grossPay = grossPay;
	}
	
	public String print(){
		return ("My gross salary is " + this.grossPay + " and My net salary is " + getNetPay());
	}
	
	public double getNetPay(){
		return this.grossPay - (this.fica + this.state + this.local + this.medicare + this.socialSercurity) * this.grossPay;	
	}

	public double getGrossPay() {
		return grossPay;
	}
}
