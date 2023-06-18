package org.jsp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchPersonByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to display person details");
		String name = sc.next();
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = m.createNamedQuery("FindByName");
		q.setParameter(1, name);
		List<Person> persons = q.getResultList();
		for(Person p:persons) {
			System.out.println(p);
		}
	}

}
