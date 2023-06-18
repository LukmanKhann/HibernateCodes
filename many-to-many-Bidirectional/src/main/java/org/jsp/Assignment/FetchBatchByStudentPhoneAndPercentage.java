package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FetchBatchByStudentPhoneAndPercentage {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter student phone and percentage to display the batch details");
	long phone = sc.nextLong();
	double perc = sc.nextDouble();
	String qry = "select s.batches from Student s where s.phone = ?1 and s.perc=?2";
	EntityManager manager  = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, phone);
	q.setParameter(2, perc);
	List<Batch> bat  = q.getResultList();
	for(Batch b:bat) {
		System.out.println("Id - "+b.getId());
      	 System.out.println("Code - "+b.getCode());
      	 System.out.println("Subject - "+b.getSubject());
      	 System.out.println("---------------");
	}
}
}
