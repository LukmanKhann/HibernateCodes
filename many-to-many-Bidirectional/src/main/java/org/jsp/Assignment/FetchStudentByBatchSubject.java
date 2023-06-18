package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Student;

public class FetchStudentByBatchSubject {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter batch subject to display the student details");
	String sub = sc.nextLine();
	String qry = "select b.students from Batch b where b.subject=?1";
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, sub);
	List<Student> stu  = q.getResultList();
	for(Student s:stu) {
		System.out.println("Name - " + s.getName());
		System.out.println("Percentage - "+s.getPerc());
		System.out.println("Phone - "+s.getPhone());
		System.out.println("-------------------");
	}
}

}
