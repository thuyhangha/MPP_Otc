package com.mpp.lab7.prob2;

public interface Polygon {
	public default double[] getSides(){
		
		return  new double [0];	
	}

	public default double computPolygPerimeter() {
		
		double [] sides = getSides();
		double sum = 0;
		for(double side : sides){
			 sum += side;
			}
		return sum;
	}
}