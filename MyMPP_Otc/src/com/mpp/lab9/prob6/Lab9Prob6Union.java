package com.mpp.lab9.prob6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lab9Prob6Union {
	public static Set<String> union(List<Set<String>> sets) {
		//Collections.emptySet()
		Set<String> setStr = sets.stream().reduce(new HashSet<String>(), (s,t) -> {s.addAll(t); return s;});
		return setStr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<String>(Arrays.asList("A", "B"));
		Set<String> set2 = new HashSet<String>(Arrays.asList("D"));
		Set<String> set3 = new HashSet<String>(Arrays.asList("1", "3", "5"));
		
		List<Set<String>> lstSet = new ArrayList<Set<String>>();
		lstSet.add(set1);
		lstSet.add(set2);
		lstSet.add(set3);
		
		Set<String> setStr = union(lstSet);
		System.out.println(setStr);
	}

}
