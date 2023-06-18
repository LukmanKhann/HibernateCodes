package org.jsp.one2one.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one.dto.PanCard;
import org.jsp.one2one.dto.Person;

public class FetchPersonByPanCard_Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Pancard Number to fetch the Person details");
		String number = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String jpql = "select pc from PanCard pc where pc.number=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, number);
		try {
			
			PanCard card = (PanCard)q.getSingleResult();
			Person persons = card.getP();
			System.out.println("name - "+persons.getName());
			System.out.println("Age - "+persons.getAge());	
			System.out.println("Phone - "+persons.getPhone());
		}
		catch(NoResultException e ) {
			System.err.println("Enterd Pancard id is invalid");
		}
	}

}
