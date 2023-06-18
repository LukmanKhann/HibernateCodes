package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.mantomany.dto.Student;

public class FetchStudentByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter student phone to display the student details");
		long phone = sc.nextLong();
		String qry = "select s from Student s where s.phone = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		try {
			Student s = (Student)q.getSingleResult();
			System.out.println("Name - "+s.getName());
			System.out.println("Percentage - "+s.getPerc());
			System.out.println("Phone - "+s.getPhone());
		}
		catch(NoResultException e ) {
			System.err.println("No record found matching this phone!!!!");
		}
	}


}
