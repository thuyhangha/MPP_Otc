package com.mpp.lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
	private List<Apartment> lstApartment;
	
	public Building() {
		setLstApartment(new ArrayList<Apartment>());
	}
	
	public Double sumProfitFromApartment(List<Apartment> lstAparement){
		Double sum = 0.0;
		for(Apartment ap : lstAparement){
			sum += ap.calProfit();
		}
		return sum;
	}
	
	public void addApartment(Double rentValue, Double maintainaceCost){
		getLstApartment().add(new Apartment(rentValue, maintainaceCost));
	}

	public List<Apartment> getLstApartment() {
		return lstApartment;
	}

	public void setLstApartment(List<Apartment> lstApartment) {
		this.lstApartment = lstApartment;
	}
}
