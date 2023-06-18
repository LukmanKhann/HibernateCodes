package org.assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchingPersonByEmailAndPassword {
	public static void main(String[] args) {
		System.out.println("enter email and password to display the details");
		Scanner sc  = new Scanner(System.in);
		String email = sc.next();
		String password = sc.next();
		String qry = "select p from Person p where p.Email = ?1 and p.Password=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			Person p = (Person)q.getSingleResult();
			System.out.println("login successfull");
			System.out.println(p);
		}
		catch(NoResultException e) {
			System.out.println("enter email and password is wrong ");
		}
		
	}

}
