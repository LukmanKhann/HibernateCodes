package org.jsp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.dto.Person;

public class FetchPersonById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your id to display your details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, id);
		if(p!=null) {
			System.out.println(p);
		}
		else {
			System.err.println("Enter Id is invalid ");
		}
		
	}

}
