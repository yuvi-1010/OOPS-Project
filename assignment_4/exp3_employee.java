// 3. Create a class called employee that include three instance variable a)name(type string) b) last name (type string) and c) monthly salary(double). Provide a constructor that initialize the three instance variable. Provide a set and a get method of instance variable. if the monthly salary is not positive do not set its value. Write a test aplication named employeetest that demonstrate class employee capabilities.create two employee object and display each object yearly salary. Then give each employee a 10% hike and display each employee yearly salary again.

import java.util.*;

class getinfo{
	String name ;
	String lastname ;
	double salary;
	getinfo(){
		name="";
		lastname="";
		salary=0.0;
	}
	void set() {
	    Scanner sc = new Scanner(System.in);

	    System.out.print("name: ");
	    name = sc.nextLine();

	    System.out.print("lastname: ");
	    lastname = sc.nextLine();

	    System.out.print("Enter salary: ");
	    salary= sc.nextDouble();
	        
	    // sc.close();	        
	    }
	    void get() {
	    	System.out.println("name: "+name);
	    	System.out.println("lastname: "+lastname);
	    	if(salary>=0.0) {
	    	System.out.println("salary: "+salary);
	    	}
	    }
	    	
	    double yearlysalary() {
	    	double yearlysalary = salary*12;
	    	return yearlysalary;
	    }
	    	
	    double newsalary() {
	    	return yearlysalary() + yearlysalary()*0.10;
	    }
}
public class exp3_employee {
	public static void main(String[] args) {
		getinfo A = new getinfo();
		getinfo B = new getinfo();
		A.set();
		B.set();
		A.get();
		B.get();
		System.out.println("Yearly Salary of A: "+A.yearlysalary());
		System.out.println("Yearly Salary of B: "+B.yearlysalary());
		System.out.println("New Salary of A: "+A.newsalary());
		System.out.println("New Salary of B: "+B.newsalary());		
	}	
}