package com.mpp.lab3.prob3;

public class Circle {
	private double  radius = 1.0;
	String color = "red";
	public static double PI = 3.14;
	public Circle() {
		
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return 3.14 * Math.pow(radius, 2);
	}
	
	public String toString() {
		return "Area =" + getArea();
	}
}
