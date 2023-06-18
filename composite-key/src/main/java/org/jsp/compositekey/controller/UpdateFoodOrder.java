package org.jsp.compositekey.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.jsp.compositekey.dto.FoodOrder;

public class UpdateFoodOrder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = manager.find(FoodOrder.class, 4);
		order.setCost(950);
		order.setFood_item("Sahi Chiken Masala");
		manager.persist(order);
		transaction.begin();
		transaction.commit();
	}

}
