package lesson5duckassignment;

public class DecoyDuck extends Duck {
	

	public DecoyDuck() {
		this.flybehavior = new Cannotfly();
		this.quackbehavior = new MuteQuack();
	}

	@Override
	public void display() {
		//DecoyDuck mydecoy = new DecoyDuck();
		System.out.println("I am a decoy duck");
		
		
	}

	

}
