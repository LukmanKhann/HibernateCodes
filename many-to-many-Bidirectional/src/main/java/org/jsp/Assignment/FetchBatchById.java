package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanybi.dto.Batch;

public class FetchBatchById {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter you Batch Id to display the batch details");
		int id = sc.nextInt();
		EntityManager manager  = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Batch b = manager.find(Batch.class, id);
		if(b!=null) {
			System.out.println("Code - "+b.getCode());
			System.out.println("Subject - "+b.getSubject());
		}
		else {
			System.err.println("invalid id");
		}
	}

}
