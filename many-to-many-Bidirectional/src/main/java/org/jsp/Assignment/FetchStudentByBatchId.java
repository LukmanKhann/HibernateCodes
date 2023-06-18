package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanybi.dto.Batch;
import org.jsp.manytomanybi.dto.Student;

public class FetchStudentByBatchId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch Id to Fetch the Student Details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Batch b = manager.find(Batch.class, id);
		if(b!=null) {
			List<Student> stu = b.getStudents();
			for(Student s:stu) {
				System.out.println("Name - " + s.getName());
				System.out.println("Percentage - "+s.getPerc());
				System.out.println("Phone - "+s.getPhone());
				System.out.println("-----------------------------");
				
			}
			
		}
		else {
			System.err.println("Enter id is invalid");
		}
	}

}
