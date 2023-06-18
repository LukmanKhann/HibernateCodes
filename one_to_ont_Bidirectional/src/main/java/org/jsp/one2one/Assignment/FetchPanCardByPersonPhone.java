package org.jsp.one2one.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one.dto.PanCard;
import org.jsp.one2one.dto.Person;

public class FetchPanCardByPersonPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Phone to display the PanCard Details");
		long phone = sc.nextLong();
		String qry = "select p from Person p where p.phone=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		try {
			Person per = (Person)q.getSingleResult();
			PanCard card = per.getCard();
			System.out.println( "DOB - "+card.getDob());
			System.out.println("Number -"+card.getNumber());
			System.out.println("Pincode -"+card.getPincode());
		}
		catch(NoResultException e) {
			System.err.println("Error");
		}
	}

}
