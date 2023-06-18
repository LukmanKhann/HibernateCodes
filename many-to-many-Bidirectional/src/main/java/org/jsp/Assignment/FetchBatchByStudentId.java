package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanybi.dto.Batch;
import org.jsp.manytomanybi.dto.Student;

public class FetchBatchByStudentId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id to display the Batch Details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Student s = manager.find(Student.class, id);
		if(s!=null) {
			List<Batch> bat = s.getBatches();
             for(Batch b:bat) {
            	 System.out.println("Id - "+b.getId());
            	 System.out.println("Code - "+b.getCode());
            	 System.out.println("Subject - "+b.getSubject());
            	 System.out.println("---------------");
             }
		}
		else {
			System.err.println("Enter Id is invalid");
		}
	}

}
