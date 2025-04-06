package com.java8.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Java8StringsOperations {
	public static void main(String[] args) {
		//Display text in init cap format
		String text = "welcome to hello world hello";
		String initCapText = Arrays.stream(text.split(" ")).map(data -> data.substring(0,1).toUpperCase()+data.substring(1)).collect(Collectors.joining(" "));
		System.out.println("initCapText : " + initCapText); //initCapText : Welcome To Hello World
		
		//Reverse the words by preserving the spaces
		String reverseWordsByPreservingSpaces = Arrays.stream(text.split(" ")).map(data -> new StringBuilder(data).reverse()).collect(Collectors.joining(" "));
		System.out.println("reverseWordsByPreservingSpaces : "+ reverseWordsByPreservingSpaces); //reverseWordsByPreservingSpaces : emoclew ot olleh dlrow
		
		//Write logic to find count of each character with out spaces
		String newText = text.replace(" ", "");
		Map<Character, Long> characterItsCountWithOutSpaces = newText.chars().mapToObj(ch -> (char)ch)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("characterItsCountWithOutSpaces : "+ characterItsCountWithOutSpaces); 
		//characterItsCountWithOutSpaces : {r=1, c=1, d=1, t=1, e=3, w=2, h=1, l=4, m=1, o=4}
		
		//Write a logic to find the words count
		Map<String, Long> wordsCountMap = Arrays.stream(text.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("wordsCountMap : " + wordsCountMap); //wordsCountMap : {world=1, hello=1, to=1, welcome=1}
		
		//Logic to find Second largest word
		String data = "Hello Worlds Hi";
		String secondHighestLengthWord = Arrays.stream(data.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
		System.out.println("secondHighestLengthWord : " + secondHighestLengthWord); //secondHighestLengthWord : Hello
		
		//Max Length word
		String maxLengthWord = Arrays.stream(text.split(" ")).max(Comparator.comparing(String::length)).get();
		System.out.println("maxLengthWord : "+ maxLengthWord); //maxLengthWord : welcome
		
		//Min Length word
		String minLengthWord = Arrays.stream(text.split(" ")).min(Comparator.comparing(String::length)).get();
		System.out.println("minLengthWord : "+ minLengthWord); //minLengthWord : to
		
		//Check two strings are anagrams
		String word1 = "abc";
		String word2 = "bac";
		String sortedWord1 = Arrays.stream(word1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		String sortedWord2 = Arrays.stream(word2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		boolean isAnagram = sortedWord1.equals(sortedWord2)?true:false;
		System.out.println("Both are anagrams : "+ isAnagram); //Both are anagrams : true
		
		//list of words sort them by length
		String sortedBasedOnLength = Arrays.stream(text.split(" ")).sorted(Comparator.comparing(String::length)).collect(Collectors.joining(" "));
		System.out.println("sortedBasedOnLength : "+ sortedBasedOnLength);	//sortedBasedOnLength : to hello world welcome

		//First repeated character
		String spaceReplacedText = text.replace(" ", "");
		 Character firstRepeatedChar = spaceReplacedText.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream().filter(value -> value.getValue()>1).map(item -> item.getKey()).findFirst().get();
		System.out.println("firstRepeatedChar :" + firstRepeatedChar); //firstRepeatedChar :w
		
		//First non repeated character
		Character firstNonRepearedChar = spaceReplacedText.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(val -> val.getValue()==1).map(key -> key.getKey()).findFirst().get();
		System.out.println("firstNonRepearedChar : "+ firstNonRepearedChar); //firstNonRepearedChar : c
		
		//Max Repeated Word
		LinkedHashMap<Character, Long> countingMap = spaceReplacedText.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		Character maxRepeatedCharacter = countingMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println("maxRepeatedCharacter : "+ maxRepeatedCharacter); //maxRepeatedCharacter : l
		
		//name starts with h
		String namesSartsWithSIs = Arrays.stream(text.split(" ")).filter(word -> word.startsWith("h")).collect(Collectors.joining(" "));
		System.out.println("namesSartsWithSIs : "+ namesSartsWithSIs); //namesSartsWithSIs : hello hello

		
		//Pattern Examples
		String specialChardData = "abc 1abc #abc @abc 2bcd bcd";
		
		//Print only characters
		Pattern charsPattern = Pattern.compile("[^a-zA-Z]");
		String onlyCharacters = Arrays.stream(specialChardData.split(" ")).map(charsData -> charsPattern.matcher(charsData).replaceAll("")).collect(Collectors.joining(" "));
		System.out.println("onlyCharacters : "+ onlyCharacters); //onlyCharacters : abc abc abc abc bcd bcd
		
		//Print only numbers
		Pattern onlyNumbersPattern = Pattern.compile("[^0-9]");
		String onlyNumbersData = Arrays.stream(specialChardData.split(" ")).map(onlyNums -> onlyNumbersPattern.matcher(onlyNums).replaceAll("")).collect(Collectors.joining(" "));
		System.out.println("onlyNumbersData : "+ onlyNumbersData); //onlyNumbersData :  1   2 
		
		//Print Alpha numerics
		Pattern alphaNumericPattern = Pattern.compile("[^a-zA-Z0-9]");
		String alphaNumericData = Arrays.stream(specialChardData.split(" ")).map(alphaNumeric -> alphaNumericPattern.matcher(alphaNumeric).replaceAll("")).collect(Collectors.joining(" "));
		System.out.println("alphaNumericData : "+ alphaNumericData); //alphaNumericData : abc 1abc abc abc 2bcd bcd
		
		//Print only special characters
		Pattern specialCharactersPattern = Pattern.compile("[a-zA-Z0-9]+");
		String specialCharactersOnly = Arrays.stream(specialChardData.split(" ")).map(specialChars -> specialCharactersPattern.matcher(specialChars).replaceAll("")).collect(Collectors.joining(" "));
		System.out.println("specialCharactersOnly : "+ specialCharactersOnly); //specialCharactersOnly :   # @  
		
		//print only duplicate words in String
		Set<String> duplicateSet = new LinkedHashSet<>();
		String duplicateCharactersOnly = Arrays.stream(text.split(" ")).filter(charData -> !duplicateSet.add(charData)).collect(Collectors.joining(" "));
		System.out.println("Duplicate Characters : "+ duplicateCharactersOnly); //Duplicate Characters : hello
		
		//remove duplicated from string and return in same order
		String uniqueWOrdsInAscendingOrder = Arrays.stream(text.split(" ")).distinct().sorted().collect(Collectors.joining(" "));
		System.out.println("uniqueWOrdsInAscendingOrder : "+ uniqueWOrdsInAscendingOrder); //uniqueWOrdsInAscendingOrder : hello to welcome world
		
			
	}

}
