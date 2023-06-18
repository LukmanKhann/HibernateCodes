package org.jsp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchingEmployeeData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to display the details");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Employee e = s.get(Employee.class, id);
	   if(e!=null) {
			System.out.println("id " + e.getId());
			System.out.println("name "+e.getName());
			System.out.println("designation "+e.getDesg());
			System.out.println("salary "+e.getSalary());
	   }
	   else {
		   System.out.println("invalid id please check and try again later");
	   }
	    
		
	}

}
