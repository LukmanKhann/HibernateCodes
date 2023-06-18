package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;


public class FetchBatchBySubject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter batch subject to display the batch details");
		String subject = sc.nextLine();
		String qry  = "select b from Batch b where b.subject = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, subject);
		
		try {
			Batch b = (Batch)q.getSingleResult();
			System.out.println("Code - "+b.getCode());
			System.out.println("Id  - "+b.getId());
			
			
		}
		catch(NoResultException e) {
			System.err.println("no result found with that subject");
		}
	}

}
