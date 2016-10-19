package com.mpp.lab9.prob1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesion9Prob1B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Stream.of("Bill", "Thomas", "Mary").collect(Collectors.joining(", ")));
	}

}
