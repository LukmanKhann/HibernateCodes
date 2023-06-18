package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FetchBatchByStudentName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student name to display the batch details");
		String name = sc.nextLine();
		String qry = "select s.batches from Student s where s.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Batch > bat = q.getResultList();
		for(Batch b:bat) {
			System.out.println("Id - "+b.getId());
       	 System.out.println("Code - "+b.getCode());
       	 System.out.println("Subject - "+b.getSubject());
       	 System.out.println("---------------");
		}
	}

}
