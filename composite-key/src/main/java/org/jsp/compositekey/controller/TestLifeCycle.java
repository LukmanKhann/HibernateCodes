package org.jsp.compositekey.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.User;

public class TestLifeCycle {
	public static void main(String[] args) {
		User u  = new User(); //Transient State
		u.setName("Lukman");
		u.setPhone(7974964);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(u); //Persistent State
		transaction.begin();
		transaction.commit();
		u.setName("saif");
		u.setPhone(90930);
		transaction.begin();
		transaction.commit();
		manager.detach(u); // Detached State
		u.setName("Kaif");
		u.setPhone(6062606);
		transaction.begin();
		transaction.commit();
		
	}

}
