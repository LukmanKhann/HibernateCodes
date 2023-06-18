package org.jsp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchPersonByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your phone number to fetch the details");
		long phone = sc.nextLong();
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = m.createNamedQuery("FindByPhone");
		q.setParameter(1, phone);
		List<Person> persons = q.getResultList();
		for(Person p:persons) {
			System.out.println(p);
		}
		
	}

}
