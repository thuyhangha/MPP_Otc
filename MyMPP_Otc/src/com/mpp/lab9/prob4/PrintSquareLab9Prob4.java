package com.mpp.lab9.prob4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintSquareLab9Prob4 {
	
	public static void printSquares(int num){
		List<Integer> streamInt = IntStream.iterate(1, n -> PrintSquareLab9Prob4.nextSquare(n))
				.limit(num).boxed()
				.collect(Collectors.toList());
		
		streamInt.forEach(System.out::println);
	}
	
	static public int nextSquare(int num) {
		int nextVal = num + 1;
		
		int squareValue = (int)Math.sqrt(nextVal);
		while(squareValue * squareValue != nextVal){
			nextVal = nextVal + 1;
			squareValue = (int)Math.sqrt(nextVal);
		}
		return nextVal;
	}
	
	public static void main(String[] arg) {
		printSquares(4);
	}
}
