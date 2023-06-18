package org.jsp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchingPhoneByUsingName {
public static void main(String[] args) {
	System.out.println("Enter Name to fetch the Phone number");
	Scanner sc = new Scanner(System.in);
	String name = sc.next();
	EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = m.createNamedQuery("FetchPhoneByName");
	q.setParameter(1, name);
	try {
		Long p = (Long)q.getSingleResult();
		System.out.println(p);
	}
	catch(NoResultException e) {
		System.err.println("No Phone number matching this name");
		
	}
}
}
