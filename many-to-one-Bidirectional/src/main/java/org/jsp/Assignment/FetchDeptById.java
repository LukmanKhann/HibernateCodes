package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytoone.dto.Department;

public class FetchDeptById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dept id to display the dept details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Department dept = manager.find(Department.class, id);
		if(dept!=null) {
			System.out.println("Name - "+dept.getName());
			System.out.println("Location -" +dept.getLocation());
		}
		else {
			System.err.println("invalid id please check!!!!");
		}
	}

}
