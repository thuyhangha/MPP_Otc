package com.mpp.lab4.prob2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee hourly = new Hourly(3, 5);
		
		Employee salaried = new Salary(450);
		
		List<Order> lstOrderVal = new ArrayList<Order>();
		lstOrderVal.add(new  Order(1, 10, LocalDate.now()));
	
		final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate1 = LocalDate.parse("09-09-2016", DATE_FORMAT);
		LocalDate localDate2 = LocalDate.parse("25-09-2016", DATE_FORMAT);
		
		lstOrderVal.add(new  Order(2, 5, localDate1));
		lstOrderVal.add(new  Order(3, 2,  localDate2));
		
		Employee commissioned = new Commissioned(2, 50, lstOrderVal);
			
		System.out.println("My value" + hourly.print(hourly.calCompensation(10, 2016)) );
		System.out.println("My value" + hourly.print(salaried.calCompensation(10, 2016)) );
		System.out.println("My value" + hourly.print(commissioned.calCompensation(10, 2016)) );
	}

}
