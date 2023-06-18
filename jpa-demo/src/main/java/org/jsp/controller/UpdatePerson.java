package org.jsp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.dto.Person;

public class UpdatePerson {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your id to update the record");
	 int id = sc.nextInt();
	 System.out.println("enter your age,email,phone,name and password");
	 int age = sc.nextInt();
	 String email = sc.next();
	 long phone = sc.nextLong();
	 String name = sc.next();
	 String password = sc.next();
	 Person p  = new Person();
	 p.setId(id);
	 p.setAge(age);
	 p.setEmail(email);
	 p.setPhone(phone);
	 p.setName(name);
	 p.setPassword(password);
	 manager.merge(p);
	 transaction.begin();
	 transaction.commit();
	}

}
