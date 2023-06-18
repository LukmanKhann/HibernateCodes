package org.jsp.one2oneUni.Controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one2oneUni.dto.PanCard;
import org.jsp.one2oneUni.dto.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Lukman");
		p.setAge(24);
		p.setPhone(123456);
		
		PanCard card = new PanCard();
		card.setDob(LocalDate.parse("1999-07-13"));
	     card.setNumber("ldf867fd");
	     card.setPincode(123456);
	     p.setCardId(card);
	     EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
	     EntityTransaction t = m.getTransaction();
	     m.persist(p);
	     t.begin();
	     t.commit();
	}

}
