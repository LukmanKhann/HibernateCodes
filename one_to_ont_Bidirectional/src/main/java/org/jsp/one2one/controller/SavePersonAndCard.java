package org.jsp.one2one.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one2one.dto.PanCard;
import org.jsp.one2one.dto.Person;



public class SavePersonAndCard {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Kaif");
		p.setAge(28);
		p.setPhone(6062);
		
		PanCard card = new PanCard();
		card.setDob(LocalDate.parse("2002-08-22"));
	     card.setNumber("xyz123");
	     card.setPincode(111);
	     
	     card.setP(p);
	     p.setCard(card);
	     EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
	     EntityTransaction t = m.getTransaction();
	     m.persist(p);
	     t.begin();
	     t.commit();
	}

}
