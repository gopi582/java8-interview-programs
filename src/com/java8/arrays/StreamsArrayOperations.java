package com.java8.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsArrayOperations {

	public static void main(String[] args) {
		
		int[] arr = {10,20,19,-1,0,59,-1,0};
		
		//Max Number
		Integer maxNumber = Arrays.stream(arr).boxed().max(Comparator.naturalOrder()).get();
		System.out.println("Max Number is Array Is : " + maxNumber); //Max Number is Array Is : 59
		
		//Min Number
		Integer minimumNumber = Arrays.stream(arr).boxed().min(Comparator.naturalOrder()).get();
		System.out.println("Min Number is Array Is : " + minimumNumber); //Min Number is Array Is : -1
		
		//Second highest number
		Integer secondHighestNumber = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("secondHighestNumber : "+ secondHighestNumber); //secondHighestNumber : 20
		
		//Find Last Number in Array
		Integer lastNumberInArray = Arrays.stream(arr).boxed().skip(arr.length-1).findFirst().get();
		System.out.println("lastNumberInArray : "+ lastNumberInArray); //lastNumberInArray : 59
		
		//Distinct Numbers
		List<Integer> uniqueNumberList = Arrays.stream(arr).boxed().distinct().toList();
		System.out.println("uniqueNumberList : "+ uniqueNumberList); //uniqueNumberList : [10, 20, 19, -1, 0, 59]
		
		//Only Duplicate Numbers
		Set<Integer> duplicateSet = new LinkedHashSet<>();
		System.out.println("Only Duplicate Elements : "+ Arrays.stream(arr).boxed().filter(num -> !duplicateSet.add(num)).toList()); //Only Duplicate Elements : [-1, 0]
		
		//In between Numbers
		List<Integer> inBetweenNumbers = Arrays.stream(arr).boxed().sorted().filter(data -> data>=10 && data<=50).toList();
		System.out.println("inBetweenNumbers : "+ inBetweenNumbers); //inBetweenNumbers : [10, 19, 20]
		
		//Sum In between numbers
		Integer sumOfInBetweenNumbers = Arrays.stream(arr).boxed().sorted().filter(data -> data>=10 && data<=50).collect(Collectors.summingInt(Integer::intValue));
		System.out.println("sumOfInBetweenNumbers : "+ sumOfInBetweenNumbers); //sumOfInBetweenNumbers : 49
		
		//Average of in between numbers
		Double averageOfInbetweenNumbers = Arrays.stream(arr).boxed().sorted().filter(data -> data>=10 && data<=50).collect(Collectors.averagingInt(Integer::intValue));
		System.out.println("averageOfInbetweenNumbers : "+ averageOfInbetweenNumbers); //averageOfInbetweenNumbers : 16.333333333333332
		
		//Display words in ascending order
		String [] stringArr = {"abcde","bace","cabt","aacm","abc"};
		List<String> ascendingOrderList = Arrays.stream(stringArr).sorted().toList();
		System.out.println("ascendingOrderList : "+ ascendingOrderList); //ascendingOrderList : [aac, abc, abc, bac, cab]
		
		//Display words in descending order
		List<String> descendingOrderList = Arrays.stream(stringArr).sorted(Comparator.reverseOrder()).toList();
		System.out.println("descendingOrderList : "+ descendingOrderList);//descendingOrderList : [cab, bac, abc, abc, aac]
		
		//Second highest word based on length
		String secondHighestLengthWord = Arrays.stream(stringArr).sorted(Comparator.comparing(String::length)).skip(1).findFirst().get();
		System.out.println("secondHighestLengthWord : "+ secondHighestLengthWord); //secondHighestLengthWord : bace
		
		//Concate two string arrays
		String [] anotherArray = {"123","456","aacm","abc"};
		List<String> concatenatedList = Stream.concat(Arrays.stream(stringArr), Arrays.stream(anotherArray)).toList();
		System.out.println("concatenatedList : "+ concatenatedList); //concatenatedList : [abcde, bace, cabt, aacm, abc, 123, 456, aacm, abc]
		
		//Common words in two arrays
		List<String> commonElementsList = Arrays.asList(stringArr).stream().filter(Arrays.asList(anotherArray)::contains).toList();
		System.out.println("commonElementsList : "+ commonElementsList); //commonElementsList : [aacm, abc]
		
		//Display only letters in list
		String[] allCharsArr = {"a12","12b","c23$","#43d"};
		Pattern onlyCharsPattern = Pattern.compile("[^a-zA-Z]");
		List<String> onlyCharsList = Arrays.stream(allCharsArr).map(data-> onlyCharsPattern.matcher(data).replaceAll("")).toList();
		System.out.println("onlyCharsList : "+ onlyCharsList); //onlyCharsList : [a, b, c, d]
		
		//Display only numbers in list
		Pattern onlyNumbersPattern = Pattern.compile("[^0-9]");
		List<String> onlyNumbersList = Arrays.stream(allCharsArr).map(data -> onlyNumbersPattern.matcher(data).replaceAll("")).toList();
		System.out.println("onlyNumbersList : "+ onlyNumbersList); //onlyNumbersList : [12, 12, 23, 43]
		
		//Display only alpha numerics in list
		Pattern alphaNumericPattern = Pattern.compile("[^a-zA-Z0-9]");
		List<String> alphaNumericList = Arrays.stream(allCharsArr).map(data -> alphaNumericPattern.matcher(data).replaceAll("")).toList();
		System.out.println("alphaNumericList : "+ alphaNumericList); //alphaNumericList : [a12, 12b, c23, 43d]
		
		//Display only special characters in list
		Pattern allCharsPattern = Pattern.compile("[a-zA-Z0-9]+");
		List<String> specialCharsList = Arrays.stream(allCharsArr).map(data -> allCharsPattern.matcher(data).replaceAll("")).toList();
		System.out.println("specialCharsList : " + specialCharsList); //specialCharsList : [, , $, #]
		
		
		int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        
        //Summing up all the elements in array
        int sumOfAllElementsInArray = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).sum();
        System.out.println("sumOfAllElementsInArray : "+ sumOfAllElementsInArray); //sumOfAllElementsInArray : 21
        
        // Summing up the same position elements in Array
        int[] summedArray = IntStream.range(0, array1.length)
                                     .map(i -> array1[i] + array2[i])
                                     .toArray();
        System.out.println("Summed Array: " + Arrays.toString(summedArray)); //Summed Array: [5, 7, 9]
		
	}

}
