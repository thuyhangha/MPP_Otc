package com.mpp.lab7.prob2;

public class EquilateralTriangle implements ClosedCurve {
	double side;
	

public EquilateralTriangle(double side) {
		super();
		this.side = side;
	}

public double getSide() {
	return side;
}





@Override
public double computePerimeter() {
	// TODO Auto-generated method stub
	return computPolygPerimeter();
}

@override	
public double[] getSides(){
	double []EquTriangle = new double [3];
	  EquTriangle[0] = this.getSide();
	  EquTriangle[1] = this.getSide();
	  EquTriangle[2] = this.getSide();
	 return EquTriangle;
	
}
}
