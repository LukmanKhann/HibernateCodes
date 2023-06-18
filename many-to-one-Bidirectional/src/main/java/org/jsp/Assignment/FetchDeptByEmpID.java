package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Department;
import org.jsp.manytoone.dto.Employee;

public class FetchDeptByEmpID {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID to display the Dept details");
		int id  = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Employee e = manager.find(Employee.class, id);
		if(e!=null) {
			Department d = e.getDept();
			System.out.println("name -" +d.getName());
			System.out.println("Location - "+d.getLocation());
		}
		else {
			System.err.println("Enter id is invalid !!!!");
		}
	}

}
