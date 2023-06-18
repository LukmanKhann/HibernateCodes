package org.jsp.one2one.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one.dto.Person;

public class FetchPersonByAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Age to fetch the person");
		int age = sc.nextInt();
		String qry= "select p from Person p where p.age = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, age);
	    List<Person> persons = q.getResultList();
	    
	    for(Person p:persons) {
	    	
	    	System.out.println("Id "+p.getId());
			System.out.println("name "+p.getName());
			System.out.println("Phone "+p.getPhone());	
	    	
	    	
	    }
	}

}
