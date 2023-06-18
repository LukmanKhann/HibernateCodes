package org.assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchingPersonDetailsByEmail {
	public static void main(String[] args) {
		System.out.println("Enter Person Emial to display details");
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		String qry = "select p from Person p where p.Email = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		try {
			Person p = (Person)q.getSingleResult();
			System.out.println("login successfull using email");
			System.out.println(p);
			
		}
		catch(NoResultException e ) {
			System.out.println("enter email is invalid failed to load any details matching this email!!! ");
			
		}
	}

}
