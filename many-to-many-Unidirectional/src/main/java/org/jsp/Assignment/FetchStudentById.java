package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.mantomany.dto.Student;

public class FetchStudentById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id to display student details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Student s  = manager.find(Student.class, id);
		if(s!=null) {
			System.out.println("Name - "+s.getName());
			System.out.println("Percentage - "+s.getPerc());
			System.out.println("Phone - "+s.getPhone());
		}
		else {
			System.err.println("invalid id please check");
		}
	}

}
