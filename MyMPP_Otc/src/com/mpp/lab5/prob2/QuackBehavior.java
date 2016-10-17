package com.mpp.lab5.prob2;

public interface QuackBehavior {
	Quack Quacksound = new Quack();
	Squeak Squeaksound = new Squeak();
	MuteQuack NoSound = new MuteQuack();
	void quack();
	
}
