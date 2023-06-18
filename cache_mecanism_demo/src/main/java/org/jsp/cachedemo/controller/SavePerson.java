package org.jsp.cachedemo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.cachedemo.dto.Person;

public class SavePerson {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person p = new Person();
		p.setName("lukman");
		p.setPhone(456);
		manager.persist(p);
		transaction.begin();
		transaction.commit();
		
		
	}

}
