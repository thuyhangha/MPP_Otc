package com.mpp.lab8.prob5;

import java.util.Arrays;
import java.util.List;

public class Redolab7prob3LamdaExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("Hello tere", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		//a
		list.forEach(x -> System.out.println(x.toUpperCase()));
		//b
		list.forEach(Redolab7prob3LamdaExpression::myMethod);
	}
	
	public static void myMethod(String x) {
		System.out.println(x.toUpperCase());
	}
}
