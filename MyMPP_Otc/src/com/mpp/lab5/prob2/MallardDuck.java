package lesson5duckassignment;

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
