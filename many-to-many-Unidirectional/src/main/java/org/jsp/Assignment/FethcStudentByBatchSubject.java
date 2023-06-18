package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.mantomany.dto.Batch;
import org.jsp.mantomany.dto.Student;

public class FethcStudentByBatchSubject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch subject to display the student details");
		String subject = sc.nextLine();
		String qry = "select b.students from Batch b where b.subject = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, subject);
		List<Student> l=q.getResultList();
		for(Student s:l)
		{
			System.out.println(s.getName());
		}
		
	}

}
