package org.jsp.cachedemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jsp.cachedemo.dto.Person;

public class FetchPerson {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager1 = factory.createEntityManager();
		EntityManager manager2= factory.createEntityManager();

		Person p1 = manager1.find(Person.class, 1);
		Person p2 = manager2.find(Person.class, 2);
		Person p3 = manager2.find(Person.class, 1);
	}

}
