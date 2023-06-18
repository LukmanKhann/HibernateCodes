package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;

public class FetchThePersonByPhoneAndEmail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter phone and mail to fetch the person details");
		long phone = sc.nextLong();
		String email = sc.next();
		PersonId pid = new PersonId();
		pid.setEmail(email);
		pid.setPhone(phone);
		 EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		 Person p = manager.find(Person.class, pid);
		 if(p!=null) {
			 System.out.println("Name - "+p.getName());
			 System.out.println("Age - "+p.getAge());
			 System.out.println("Email - "+p.getId().getEmail());
			 System.out.println("Phone - "+p.getId().getPhone());
		 }
		 else {
			 System.err.println("You Have Entered Invalid Phone And Email");
		 }
	}

}
