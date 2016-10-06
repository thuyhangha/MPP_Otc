package com.mpp.lab4.prob2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee{
	private double commission = 0.0;
	private double baseSalary = 0.0; 
	
	List<Order> lstOrder;
	
	public Commissioned(double commission, double baseSalary, List<Order> lstOrderVal) {
		// TODO Auto-generated constructor stub
		this.setCommission(commission);
		this.baseSalary = baseSalary;
		lstOrder = new ArrayList<Order>();
		lstOrder.addAll(lstOrderVal);
	}
	
	@Override
	double calGrossPay(int month, int year) {
		// TODO Auto-generated method stub

		LocalDate currentLocalDate = LocalDate.of(year, month, 1);
		double totalOrderVal = 0.0;
		for(Order orderItem : lstOrder){
			if(isPreviousMonth(currentLocalDate, orderItem.getOrderDate()))
				totalOrderVal += orderItem.getOrderAmount();
		}
		
		return this.baseSalary + this.getCommission() * totalOrderVal;
	}

	public double getCommission() {
		return baseSalary ;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public boolean isPreviousMonth(LocalDate currentLocalDate, LocalDate lastMonthLocalDate){
	
		if((currentLocalDate.getMonthValue() - lastMonthLocalDate.getMonthValue() == 1) 
				&& currentLocalDate.getYear() ==lastMonthLocalDate.getYear())
					return true;
		return false;
	}
}
