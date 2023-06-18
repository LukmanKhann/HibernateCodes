package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.mantomany.dto.Batch;
import org.jsp.mantomany.dto.Student;

public class ListingStudentByBatchCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter batch code to display student details");
		String code = sc.next();
		String qry = "select b.students from Batch b where b.code=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, code);
		List<Student> l=q.getResultList();
		for(Student s:l)
		{
			System.out.println(s.getName());
		}
	}

}
