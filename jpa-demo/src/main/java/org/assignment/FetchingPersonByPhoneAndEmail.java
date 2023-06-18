package org.assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchingPersonByPhoneAndEmail {
	public static void main(String[] args) {
		System.out.println("Enter Person phone number and email to display all the details");
		Scanner sc  = new Scanner(System.in);
		long phone = sc.nextLong();
		String email = sc.next();
		String qry = "select p from Person p where p.Phone =?1 and p.Email = ?2";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery (qry);
		q.setParameter(1, phone);
		q.setParameter(2, email);
		try {
			Person p = (Person)q.getSingleResult();
			System.out.println("Login Successfull");
			System.out.println(p);
		}
		catch(NoResultException e ) {
			System.out.println("entered phone and password is invalid ");
		}
	}

}
