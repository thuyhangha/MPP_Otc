package com.mpp.lab8.prob1.J;

import java.util.function.Supplier;

public class i_ii {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supplier<Double> sup = () -> Math.random(); 
		System.out.println(sup.get());
	}

}
