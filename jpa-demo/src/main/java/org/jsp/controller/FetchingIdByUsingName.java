package org.jsp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchingIdByUsingName {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter name to display id of the person");
	String name = sc.next();
	EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = m.createNamedQuery("FetchIdByName");
	q.setParameter(1, name);
	try {
		Integer p = (Integer)q.getSingleResult();
		System.out.println("fetched successfull");
		System.out.println( "ID --"+p);
	}
	catch(NoResultException e ) {
		System.err.println("There is no id matching this name ");
	}
}
}
