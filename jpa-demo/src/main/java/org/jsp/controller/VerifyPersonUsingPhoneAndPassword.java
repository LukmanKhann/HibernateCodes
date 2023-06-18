package org.jsp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class VerifyPersonUsingPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("enter your Phone number and Password to display person Details");
		long phone = sc.nextLong();
		String password = sc.next();
		String qry = "select p from Person p where p.Phone = ?1 and p.Password = ?2";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
		Person p = (Person) q.getSingleResult();
		System.out.println("login successfull");
		System.out.println(p);
		}
		catch(NoResultException e) {
			System.err.println("Invalid Phone number and password");
		}
	}
		

}
