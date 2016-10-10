package Ass3;

public final class Circle implements Shape{
	
	private final int radius;
	
	public Circle(int radius)
	{
		this.radius =radius;
		
	}

	
	public int getRadius()
	{
		return radius;
	}
	
	
	
	@Override
	public double computeArea() 
	{
		return radius*radius*Math.PI;
		
	}
	

}
