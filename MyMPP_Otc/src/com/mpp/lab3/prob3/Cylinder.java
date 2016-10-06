package com.mpp.lab3.prob3;

public class Cylinder extends Circle{
	double height = 0.0;
	double volume = 0.0;
	public Cylinder() {
		// TODO Auto-generated constructor stub
		super(1.0);
		double height = 1.0;
		this.volume = this.getArea() * height;
	}
	
	public Cylinder(double radius) {
		// TODO Auto-generated constructor stub
		super(radius);
		double height = 1.0;
		this.volume = this.getArea() * height;
	}
	
	public Cylinder(double radius,  double  height) {
		// TODO Auto-generated constructor stub
		super(radius);
		this.volume = this.getArea() * height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getVolume() {
		return volume;
	}
}
