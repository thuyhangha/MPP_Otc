package com.mpp.lab3.prob3;

public class CylinderComposition{
	double height = 0.0;
	double volume = 0.0;
	Circle circle;
	
	public CylinderComposition() {
		// TODO Auto-generated constructor stub
		circle = new Circle(1.0);
		double height = 1.0;
		this.volume = circle.getArea() * height;
	}
	
	public CylinderComposition(double radius) {
		// TODO Auto-generated constructor stub
		circle = new Circle(1.0);
		double height = 1.0;
		this.volume = circle.getArea() * height;
	}
	
	public CylinderComposition(double radius,  double  height) {
		// TODO Auto-generated constructor stub
		circle = new Circle(1.0);
		this.volume = circle.getArea() * height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getVolume() {
		return volume;
	}
}
