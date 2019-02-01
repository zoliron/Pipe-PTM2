package Ex6;

import Ex6.Q1.Employee;

public class MainTrain1 {

	public static void main(String[] args) {
		// test API
		Q1.testAPI();

		Employee e0=Employee.createEmployee("ABC", 25, 10000);
		Employee e01=Employee.createEmployee("ABC", 25, 10000); // the same employee as e0
		Employee e02=Employee.createEmployee("ABC", 25, 10000); // the same employee as e0
		Employee e1=Employee.createEmployee("ABC", 26, 10000);
		Employee e2=Employee.createEmployee("ABC", 25, 10000.1);
		Employee e3=Employee.createEmployee("CBA", 25, 10000);
		Employee e4=Employee.createEmployee("CBA", 26, 10000);

		if(Employee.employeeCount!=5)
			System.out.println("Problem with employee count (-5)");


		Employee.deleteEmployee(e4);
		Employee.deleteEmployee(e0);
		if(Employee.employeeCount!=3)
			System.out.println("Problem with employee count after delete (-5)");


		System.out.println("done");

	}

}
