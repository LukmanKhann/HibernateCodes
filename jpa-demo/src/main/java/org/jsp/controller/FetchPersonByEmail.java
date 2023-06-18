package org.jsp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchPersonByEmail {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter email to fetch person details");
	String email = sc.next();
	EntityManager m =  Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = m.createNamedQuery("FindByEmail");
	q.setParameter(1, email);
	List<Person> persons = q.getResultList();
	for(Person p:persons) {
		System.out.println(p);
	} 	
}
}
