package com.mpp.lab3.prob2;

public class Apartment {
	Double maintainaceCost;
	Rent rent;
	
	public Apartment(Double rentValue, Double maintainaceCost){
		rent = new Rent(rentValue);
		this.maintainaceCost = maintainaceCost;
	}
	
	public Double calProfit(){
		return this.rent.getRent() - this.maintainaceCost;
	}
}
