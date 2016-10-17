package com.mpp.lab5.prob3;

public final class Rectangle implements Shape {
	

	private final int width;
	private final int height;
	public Rectangle(int width,int height)
	{
		this.width=width;
		this.height=height;
	}

	
	public int getwidth()
	{
		return width;
	}
	
	
	public int getheight()
	{
		return height;
	}
	@Override
	public double computeArea() 
	{
		return width*height;
		
	}
	

}

