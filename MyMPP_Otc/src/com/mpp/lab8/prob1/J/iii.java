package com.mpp.lab8.prob1.J;

import java.util.function.Supplier;

public class iii {
	public static void main(String[] args) {
		mySubpplier my = (new iii()).new mySubpplier();
		System.out.println(my.get());
	}
	
	public class mySubpplier implements Supplier<Double>{

		@Override
		public Double get() {
			// TODO Auto-generated method stub
			return Math.random();
		}
		
	}
}
