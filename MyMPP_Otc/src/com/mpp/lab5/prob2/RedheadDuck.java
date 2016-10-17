package com.mpp.lab5.prob2;

public class RedheadDuck extends Duck {
	

	public RedheadDuck() {
		this.flybehavior = new Cannotfly();
		this.quackbehavior = new Quack();
	}

	@Override
	public void display() {
		//RedheadDuck myredheadduck = new RedheadDuck();
		System.out.println("I am Red head Duck");
		
	}

	
}
