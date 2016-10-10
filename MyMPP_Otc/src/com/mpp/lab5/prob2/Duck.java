package lesson5duckassignment;

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
