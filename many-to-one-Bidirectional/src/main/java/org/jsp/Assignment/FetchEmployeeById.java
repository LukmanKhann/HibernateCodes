package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytoone.dto.Employee;

public class FetchEmployeeById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Emp id to display the employees details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Employee e = manager.find(Employee.class, id);
		if(e!=null) {
			System.out.println("Name - "+e.getName());
			System.out.println("Designation -"+e.getDesg());
			System.out.println("Salary -"+e.getSalary());
		}
		else {
			System.err.println("invalid id");
		}
	}

}
