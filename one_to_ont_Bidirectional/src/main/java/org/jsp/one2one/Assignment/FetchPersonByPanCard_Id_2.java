package org.jsp.one2one.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one.dto.Person;

public class FetchPersonByPanCard_Id_2 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Pancard id to fetch the Person details");
	int pancardid = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	String jpql = "select p from Person p where p.card.id = ?1";
//	String jpql = "select pc.p from PanCard pc where pc.id = ?1";
	Query q = manager.createQuery(jpql);
	q.setParameter(1, pancardid);
	try {
		Person p = (Person)	q.getSingleResult();
		System.out.println("name - "+p.getName());
		System.out.println("Age - "+p.getAge());	
		System.out.println("Phone - "+p.getPhone());
	}
	catch(NoResultException e ) {
		System.err.println("Enterd Pancard id is invalid");
	}
}

}
