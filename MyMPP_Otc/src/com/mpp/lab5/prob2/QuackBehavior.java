package lesson5duckassignment;

public interface QuackBehavior {
	Quack Quacksound = new Quack();
	Squeak Squeaksound = new Squeak();
	MuteQuack NoSound = new MuteQuack();
	void quack();
	
}
