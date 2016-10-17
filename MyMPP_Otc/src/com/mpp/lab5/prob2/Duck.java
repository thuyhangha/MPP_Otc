package com.mpp.lab5.prob2;

public abstract class Duck  {
	FlyBehavior flybehavior;
	QuackBehavior quackbehavior;
	
	public abstract void display();
	
	public void swim(){
		System.out.println("I can swim");
		
	}
	public void fly(){
		flybehavior.fly();
		
	}
	public void quack(){
		quackbehavior.quack();
		
	}
}
