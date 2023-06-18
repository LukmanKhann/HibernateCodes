package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Student;

public class FetchStudentByBatchCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch Code to Fetch the Student Details");
		String code = sc.next();
		String qry = "select b.students from Batch b where b.code=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, code);
		List<Student> std = q.getResultList();
		for(Student s:std) {
			System.out.println("Name - " + s.getName());
			System.out.println("Percentage - "+s.getPerc());
			System.out.println("Phone - "+s.getPhone());
			System.out.println("------------------------------");
		}
	}

}
