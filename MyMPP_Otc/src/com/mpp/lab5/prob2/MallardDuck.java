package com.mpp.lab5.prob2;

public class MallardDuck extends Duck{

public MallardDuck() {
		this.flybehavior = new FlyWithWings();
		this.quackbehavior = new Quack();
		
	}

	@Override
	public void display() {
		//MallardDuck breedmalard = new MallardDuck();
		System.out.println("I am MallardDuck");
		
		
	}

}
