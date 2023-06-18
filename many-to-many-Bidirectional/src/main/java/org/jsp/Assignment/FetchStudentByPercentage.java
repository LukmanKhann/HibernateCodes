package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Student;

public class FetchStudentByPercentage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student percentage to display the student details");
		double perc  = sc.nextDouble();
		String qry = "select s from Student s where s.perc =?1";
		EntityManager manager  = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, perc);
		List<Student> stu = q.getResultList();
		for(Student s:stu) {
			System.out.println("Name - " + s.getName());
			System.out.println("Percentage - "+s.getPerc());
			System.out.println("Phone - "+s.getPhone());
		}
	}

}
