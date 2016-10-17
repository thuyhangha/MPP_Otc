package com.mpp.lab5.prob2;

public class RubberDuck extends Duck {
	

	public RubberDuck() {
		this.flybehavior = new Cannotfly();
		this.quackbehavior = new Squeak();
	}

	@Override
	public void display() {
		//RubberDuck myrubberduck = new RubberDuck();
		System.out.println("I am a rubber duck");
		
	}

	
}
