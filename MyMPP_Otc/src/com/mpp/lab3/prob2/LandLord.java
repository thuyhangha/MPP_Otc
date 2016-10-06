package com.mpp.lab3.prob2;

public class LandLord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Building building = new Building();
		building.addApartment(5.0, 2.0);
		building.addApartment(5.0, 2.0);
		building.addApartment(5.0, 2.0);
		
		System.out.println(building.sumProfitFromApartment(building.getLstApartment()));
	}

}
