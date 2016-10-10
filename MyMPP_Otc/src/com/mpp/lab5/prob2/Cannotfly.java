package lesson5duckassignment;

public class Cannotfly implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't fly");
		
	}

}
