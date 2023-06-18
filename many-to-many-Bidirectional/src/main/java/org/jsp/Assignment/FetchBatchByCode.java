package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FetchBatchByCode {
public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	System.out.println("enter batch code to display the batches");
	String code = sc.next();
	String qry = "select b from Batch b where b.code = ?1";
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, code);
	try {
		Batch b = (Batch) q.getSingleResult();
		System.out.println("Id - "+b.getId());
		System.out.println("Subject - "+b.getSubject());
	}
	catch(NoResultException e ) {
		System.err.println("no result found with that code!!");
	}
}
}
