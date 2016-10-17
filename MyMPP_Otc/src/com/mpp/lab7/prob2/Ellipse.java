package com.mpp.lab7.prob2;

public class Ellipse implements ClosedCurve {

	double a;
	double E;
	
	
	public Ellipse(double a, double e) {
		super();
		this.a = a;
		E = e;
	}


	public double getA() {
		return a;
	}


	public void setA(double a) {
		this.a = a;
	}


	public double getE() {
		return E;
	}


	public void setE(double e) {
		E = e;
	}


	@Override
	public double computePerimeter() {
		// TODO Auto-generated method stub
		return 4*this.a*this.E;
	}
}
