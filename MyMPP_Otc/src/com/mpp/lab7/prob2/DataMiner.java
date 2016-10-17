package com.mpp.lab7.prob2;

import java.util.ArrayList;
import java.util.List;

public class DataMiner {
	List<ClosedCurve> objects = new ArrayList<>();
	public static void main(String[] args) {
		EquilateralTriangle x = new EquilateralTriangle(10);
		System.out.println(x.computePerimeter());
		DataMiner dm = new DataMiner();
		//dm.objects.add(new Rectangle(5,7));
		//dm.objects.add(new Rectangle(2,9));
		//dm.objects.add(new Circle(6));
		//dm.objects.add(new EquilateralTriangle(10));
		//dm.objects.add(new Ellipse(6,8));
		
		//System.out.println(dm.computeAveragePerimeter());
		
	}
	
	//OO (good) way of performing computation
	public double computeAveragePerimeter() {
		if(objects == null || objects.isEmpty()) return 0.0;
		double sum = 0.0;
		for(int i = 0; i < objects.size(); ++i) {
			sum += objects.get(i).computePerimeter();
		}
		return sum/objects.size();
	}

}
