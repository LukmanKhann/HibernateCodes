package org.jsp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchingAgeById {
public static void main(String[] args) {
	Scanner sc =  new Scanner(System.in);
	System.out.println("enter id to fetch the person age");
	int id = sc.nextInt();
	EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = m.createNamedQuery("FetchAgeById");
	q.setParameter(1, id);
	try {
		Integer p = (Integer)q.getSingleResult();
		System.out.println("fetched");
		System.out.println(p);
	}
	catch(NoResultException e) {
		System.err.println("id is not matching any age");
	}
}
}
