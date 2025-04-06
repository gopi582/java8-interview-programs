package com.java8.hashmap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.java8.model.Employee;

public class Java8MapOperations {

	public static void main(String[] args) {
		Map<Integer, String> dataMap = new HashMap<>();
		dataMap.put(101, "Alex");
		dataMap.put(103, "Bob");
		dataMap.put(104, "Dan");
		dataMap.put(102, "Carey");
		dataMap.put(106, "Carey");
		
		//Sort Based On Key
		Map<Integer, String> sortedBasedOnKey = dataMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("sortedBasedOnKey : "+ sortedBasedOnKey); //sortedBasedOnKey : {101=Alex, 102=Carey, 103=Bob, 104=Dan}
		
		//Sort Based on Value
		Map<Integer, String> sortBasedOnValue = dataMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("sortBasedOnValue : "+ sortBasedOnValue); //sortBasedOnValue : {101=Alex, 102=Carey, 103=Bob, 104=Dan}
		
		//Remove duplicate values
		Map<Integer, String> afterRemovingDuplicateValues = dataMap.entrySet().stream().filter(entry -> Collections.frequency(dataMap.values(), entry.getValue())==1)
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("afterRemovingDuplicateValues : "+ afterRemovingDuplicateValues); //afterRemovingDuplicateValues : {101=Alex, 103=Bob, 104=Dan}
		
		//Map Operations on Objects
		Map<Integer, Employee> empDataMap = new HashMap<>(); 
		empDataMap.put(1,new Employee(101,"Alex","Male",20000));
		empDataMap.put(3,new Employee(102,"Bob","Male",30000));
		empDataMap.put(2,new Employee(105,"Sita","FeMale",80000));
		empDataMap.put(5,new Employee(104,"Carey","Male",60000));
		empDataMap.put(4,new Employee(103,"Geeta","FeMale",10000));
		
		//Sort by Gender
		Map<Integer, Employee> genderMap = new LinkedHashMap<>();
		empDataMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getGender)))
		.forEach(data -> genderMap.put(data.getKey(), data.getValue()));
		System.out.println("genderMap: " +genderMap);
		//genderMap: {2=Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0], 4=Employee [employeeId=103, name=Geeta, gender=FeMale, salary=10000.0], 
		//1=Employee [employeeId=101, name=Alex, gender=Male, salary=20000.0], 3=Employee [employeeId=102, name=Bob, gender=Male, salary=30000.0],
		//5=Employee [employeeId=104, name=Carey, gender=Male, salary=60000.0]}
		
		
		
		
	}
}
