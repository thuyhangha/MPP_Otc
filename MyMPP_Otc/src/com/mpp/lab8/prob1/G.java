package com.mpp.lab8.prob1;

import java.util.function.Consumer;

public class G{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// I choose the first reference method object::instanceMethod.
		//Given a class ClassName System and one of its instance methods  println(), the lambda expression
		 Consumer<String> cons = System.out::println;
		 cons.accept("Test");
	}

}
