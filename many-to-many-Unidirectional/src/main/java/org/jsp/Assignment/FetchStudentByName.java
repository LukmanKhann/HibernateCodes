package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.mantomany.dto.Student;

public class FetchStudentByName {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter student name to display the student details");
	String name = sc.next();
	String qry = "select s from Student s where s.name= ?1";
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, name);
	try {
		Student s = (Student)q.getSingleResult();
		System.out.println("Id - "+s.getId());
		System.out.println("Percentage - "+s.getPerc());
		System.out.println("Phone - "+s.getPhone());
		
	}
	catch(NoResultException e){
		System.err.println("no record match with that name !!!!!");
		
	}
}
}
