package Ex6;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;

import org.omg.Messaging.SyncScopeHelper;

public class Q1 {


	public static class Employee{

		// ------- DO NOT CHANGE ------------------
		static int employeeCount=0;

		final String name;
		final int age;
		final double salary;

		private Employee(String name,int age,double salary) {
			this.name=name;
			this.age=age;
			this.salary=salary;
			employeeCount++;
		}

		@Override
		public int hashCode(){
			return (name+age+salary).hashCode();
		}

		// ------------------------------------------

        static HashMap<Integer, Employee> hashMap = new HashMap<>();

		public static Employee createEmployee(String name,int age,double salary){
            Employee checkEmployee = hashMap.get((name+age+salary).hashCode());
            if (checkEmployee != null){
                return checkEmployee;
            }
            Employee employee = new Employee(name, age, salary);
            hashMap.put((name+age+salary).hashCode(), employee);
            return employee;
		}

		public static void deleteEmployee(Employee e){
		    hashMap.remove(e.hashCode());
		    employeeCount--;
		}

		public static boolean exists(Employee e){
		    return hashMap.containsKey(e.hashCode());
		}

	}

	public static void testAPI() {
		Employee e0=Employee.createEmployee("ABC", 25, 10000);
		Employee e1=Employee.createEmployee("ABC", 25, 10000); // the same employee as e0
		Employee e2=Employee.createEmployee("ABC", 26, 10000);
		Employee e3=Employee.createEmployee("ABC", 25, 10000.1);
		Employee e4=Employee.createEmployee("CBA", 25, 10000);

		System.out.println(e0==e1); // true
		System.out.println(Employee.employeeCount); // 4 (not 5...)

		Employee.deleteEmployee(e0);
		System.out.println(Employee.employeeCount); // 3
		System.out.println(Employee.exists(e0)); // false
		System.out.println(Employee.exists(e1)); // false
		System.out.println(Employee.exists(e2)); // true
		System.out.println(Employee.exists(e3)); // true
		System.out.println(Employee.exists(e4)); // true
	}

}
