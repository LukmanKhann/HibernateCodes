package org.jsp.compositekey.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.compositekey.dto.Person;
import org.jsp.compositekey.dto.PersonId;

public class SavePerson {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter name,age,phone and email id");
	String name = sc.next();
	int age = sc.nextInt();
	long phone = sc.nextLong();
	String email = sc.next();
	PersonId id = new PersonId();
	id.setEmail(email);
	id.setPhone(phone);
	Person p = new Person();
	p.setAge(age);
	p.setName(name);
	p.setId(id);
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	manager.persist(p);
	transaction.begin();
	transaction.commit();
	
	
}
}
