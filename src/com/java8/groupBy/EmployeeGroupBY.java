package com.java8.groupBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java8.model.Employee;

public class EmployeeGroupBY {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101,"Alex","Male",20000));
		empList.add(new Employee(102,"Bob","Male",30000));
		empList.add(new Employee(105,"Sita","FeMale",80000));
		empList.add(new Employee(104,"Carey","Male",60000));
		empList.add(new Employee(103,"Geeta","FeMale",10000));
		
		//Group By Employee Name
		Map<String, List<Employee>> groupByEmployeeName = empList.stream().collect(Collectors.groupingBy(Employee::getName));
		System.out.println("groupByEmployeeName : "+ groupByEmployeeName);
		//groupByEmployeeName : {Alex=[Employee [employeeId=101, name=Alex, gender=Male, salary=20000.0]], Geeta=[Employee [employeeId=103, name=Geeta, gender=FeMale, salary=10000.0]],
		//Sita=[Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0]], Bob=[Employee [employeeId=102, name=Bob, gender=Male, salary=30000.0]], 
		//Carey=[Employee [employeeId=104, name=Carey, gender=Male, salary=60000.0]]}
		
		//Logic to print employees based on Gender
		Map<String, List<String>> groupByGenderAndName = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("groupByGenderAndName : " + groupByGenderAndName); //groupByGenderAndName : {Male=[Alex, Bob, Carey], FeMale=[Sita, Geeta]}
		
		//Logic to count the employees based on gender
		Map<String, Long> employeesCountBasedOnGender = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("employeesCountBasedOnGender : " + employeesCountBasedOnGender); //employeesCountBasedOnGender : {Male=3, FeMale=2}
		
		//Write logic to find the average salary based on gender
		Map<String, Double> genderWiseAverageSalary = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("genderWiseAverageSalary : "+ genderWiseAverageSalary); //genderWiseAverageSalary : {Male=36666.666666666664, FeMale=45000.0}
		
		

	}

}
