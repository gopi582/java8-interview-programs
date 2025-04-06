package com.java8.streams.on.objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.java8.model.Employee;

public class EmployeeStreamOperations {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101,"Alex","Male",20000));
		empList.add(new Employee(102,"Bob","Male",30000));
		empList.add(new Employee(105,"Sita","FeMale",80000));
		empList.add(new Employee(104,"Carey","Male",60000));
		empList.add(new Employee(103,"Geeta","FeMale",10000));
		empList.add(new Employee(105,"Sita","FeMale",80000));
		
		//Write logic to display distinct Employee details in Ascending Order
		TreeSet<Employee> uniqueEmployeeList = empList.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getEmployeeId))));
		System.out.println("uniqueEmployeeList : "+ uniqueEmployeeList); 
		//uniqueEmployeeList : [Employee [employeeId=101, name=Alex, gender=Male, salary=20000.0], Employee [employeeId=102, name=Bob, gender=Male, salary=30000.0], 
		//Employee [employeeId=103, name=Geeta, gender=FeMale, salary=10000.0], Employee [employeeId=104, name=Carey, gender=Male, salary=60000.0], 
		//Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0]]
		
		//Write logic to display distinct Employee details in Descending Order
		TreeSet<Employee> uniqueEmployeeListInDescendingOrder = empList.stream().collect(Collectors.toCollection(
				() -> new TreeSet<>(Comparator.comparing(Employee::getEmployeeId).reversed())));
		System.out.println("uniqueEmployeeListInDescendingOrder : " + uniqueEmployeeListInDescendingOrder);
		//uniqueEmployeeListInDescendingOrder : [Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0], 
		//Employee [employeeId=104, name=Carey, gender=Male, salary=60000.0], Employee [employeeId=103, name=Geeta, gender=FeMale, salary=10000.0], 
		//[employeeId=102, name=Bob, gender=Male, salary=30000.0], Employee [employeeId=101, name=Alex, gender=Male, salary=20000.0]]
		
		//Write a logic to sort employee based on his salary in ascending order
		List<Employee> sortingEmployeeBySalary = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();
		System.out.println("sortingEmployeeBySalary : "+ sortingEmployeeBySalary);
		//sortingEmployeeBySalary : [Employee [employeeId=103, name=Geeta, gender=FeMale, salary=10000.0], 
		//Employee [employeeId=101, name=Alex, gender=Male, salary=20000.0], Employee [employeeId=102, name=Bob, gender=Male, salary=30000.0],
		//Employee [employeeId=104, name=Carey, gender=Male, salary=60000.0], Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0], 
		//Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0]]

		//Write a logic to sort employee based on his salary in descending order
		List<Employee> sortEmployeeBySalaryInDescending = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
		System.out.println("sortEmployeeBySalaryInDescending : " + sortEmployeeBySalaryInDescending);
		//sortEmployeeBySalaryInDescending : [Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0], 
		//Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0], Employee [employeeId=104, name=Carey, gender=Male, salary=60000.0], 
		//Employee [employeeId=102, name=Bob, gender=Male, salary=30000.0], Employee [employeeId=101, name=Alex, gender=Male, salary=20000.0], 
		//Employee [employeeId=103, name=Geeta, gender=FeMale, salary=10000.0]]
		
		//Filter Employees whose salary is >20000 and display their names
		List<String> employeeSalaryGreaterThan20000 = empList.stream().filter(emp -> emp.getSalary()>20000).map(emp->emp.getName()).toList();
		System.out.println("employeeSalaryGreaterThan20000 : "+ employeeSalaryGreaterThan20000); //employeeSalaryGreaterThan20000 : [Bob, Sita, Carey, Sita]
		
		//Filter employee list whose name starts with S
		List<Employee> employeeNameStartsWithS = empList.stream().filter(emp -> emp.getName().startsWith("S")).toList();
		System.out.println("employeeNameStartsWithS : "+ employeeNameStartsWithS); 
		//employeeNameStartsWithS : [Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0], Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0]]
		
		//Find the Max salary Employee details
		Employee employeeWithMaxSalary = empList.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("employeeWithMaxSalary : "+ employeeWithMaxSalary); //employeeWithMaxSalary : Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0]
		
		//Find Employee with Minimum Salary
		Employee minimumSalaryEmployee = empList.stream().min(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("minimumSalaryEmployee : "+ minimumSalaryEmployee); //minimumSalaryEmployee : Employee [employeeId=103, name=Geeta, gender=FeMale, salary=10000.0]
		
		//Second Highest Salary
		Employee secondHighestSalaryEmployee = empList.stream().distinct().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
		System.out.println("secondHighestSalaryEmployee : "+ secondHighestSalaryEmployee); //secondHighestSalaryEmployee : Employee [employeeId=105, name=Sita, gender=FeMale, salary=80000.0]
		
		//Display the employee names whose salary between 30000 and 50000
		List<String> employeeNamesList = empList.stream().filter(emp -> emp.getSalary()>=30000 && emp.getSalary()<=80000).map(emp -> emp.getName()).toList();
		System.out.println("employeeNamesList : "+ employeeNamesList); //employeeNamesList : [Bob, Sita, Carey, Sita]
		
		//Count the employees whose salary between 30000 and 50000
		long employeeCount = empList.stream().filter(emp -> emp.getSalary()>=30000 && emp.getSalary()<=80000).count();
		System.out.println("employeeCount : "+ employeeCount); //employeeCount : 4
		
		//Write a logic to check any of the employee name is Alex
		boolean anyMatch = empList.stream().anyMatch(emp -> emp.getName().equalsIgnoreCase("Alex"));
		System.out.println("anyMatch : "+ anyMatch); //anyMatch : true


	}

}
