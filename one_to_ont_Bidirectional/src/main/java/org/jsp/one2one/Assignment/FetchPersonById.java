package org.jsp.one2one.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one.dto.Person;

public class FetchPersonById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to Fetch Person");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Person p =	manager.find(Person.class, id);
	if(p!=null) {
		System.out.println("Name "+p.getName());
		System.out.println("Age "+p.getAge());
		System.out.println("Phone "+p.getPhone());
		
	}
	else {
		System.err.println("Your Entered Id is wrong");
	}
		
		
	}

}
