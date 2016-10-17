package com.mpp.lab5.prob3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	static List<Shape>list=new ArrayList<Shape>();
	
	public double areaSum()
	{
		double sum=0.0;
		if(list==null||list.isEmpty()==true)
			return 0.0;
		else
		//double sum=0.0;
		for(Shape s:list)
		{
			sum+=s.computeArea();
		}
		
		return sum;
	}
	
	public static void main (String args[])
	{
		Main m=new Main();
		m.list.add(new Circle(6));
		m.list.add(new Rectangle(6,2));
		m.list.add(new Triangle(6,2));
		System.out.println(m.areaSum());
	}
	
	//class Diagram
}
