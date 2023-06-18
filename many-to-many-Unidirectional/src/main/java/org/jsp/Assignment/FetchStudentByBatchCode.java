package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.mantomany.dto.Batch;
import org.jsp.mantomany.dto.Student;

public class FetchStudentByBatchCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch code to display the student details");
		String code = sc.next();
		String qry = "select b from Batch b where b.code = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, code);
		try {
			Batch b = (Batch) q.getSingleResult();
			List<Student> stds = b.getStudents();
			for(Student s:stds) {
				System.out.println("Name - "+s.getName());
				System.out.println("Percentage - "+s.getPerc());
				System.out.println("Phone - "+s.getPhone());
				System.out.println("------------------------");
			}
		}
		catch(NoResultException e) {
			System.err.println("enter Batch code is invalid");
		}
	}

}
