package com.mpp.lab5.prob3;

public final class Triangle implements Shape{
	
	
	private final int base;
	private final int height;
	public Triangle(int base,int height)
	{
		this.base=base;
		this.height=height;
	}

	
	public int getBase()
	{
		return base;
	}
	
	
	public int getheight()
	{
		return height;
	}
	@Override
	public double computeArea() 
	{
		return 1/2 * base * height;
		
	}
	

}
