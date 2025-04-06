package com.java8.integers;

import java.util.stream.Collectors;

public class StreamIntegersPrograms {

	public static void main(String[] args) {
		int data =123456;
		
		//Calculate the sum of all numbers
		Integer sumOfAllIntegers = String.valueOf(data).chars().
				mapToObj(ch -> String.valueOf((char)ch)).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println("Sum of all nymbers : " + sumOfAllIntegers); //Sum of all nymbers : 21
		
		//Reverse Number
		
		StringBuilder reverseNumber = new StringBuilder(String.valueOf(data).chars().
				mapToObj(ch -> String.valueOf((char)ch)).collect(Collectors.joining())).reverse();
		System.out.println("reverseNumber : "+ reverseNumber); //reverseNumber : 654321
		
	}

}
