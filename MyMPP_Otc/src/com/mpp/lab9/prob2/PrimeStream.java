package com.mpp.lab9.prob2;

import java.util.stream.Stream;

public class PrimeStream {
	
	public void printFirstNPrimes(long nPrimes){
		//Stream<BigInteger> primes = Stream.iterate(BigInteger.ONE.add(BigInteger.ONE), n -> BigInteger.probablePrime(10, rnd)).limit(nPrimes);
		
		Stream<Integer> primes = Stream.iterate(2, n -> nextPrime(n)).limit(nPrimes);
		primes.forEach(System.out::println);
	}
	
	public int nextPrime(int prime) {
		int nextPrime = prime + 1;
		while(!isPrime(nextPrime)){
			nextPrime = nextPrime + 1;
		}
		return nextPrime;
	}
	
	public boolean isPrime(int num){
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] arg) {
		PrimeStream ps = new PrimeStream();
		ps.printFirstNPrimes(10);
		System.out.println("=========");
		ps.printFirstNPrimes(5);
	}
}
