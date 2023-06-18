package org.jsp.compositekey.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.User;

public class DeletePerson {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User u = manager.find(User.class, 1);
		manager.remove(u);
		transaction.begin();
		transaction.commit();
	}

}
