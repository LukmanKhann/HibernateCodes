package org.jsp.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;



public class FetchAllPeopleDetails {
	public static void main(String[] args) {
		String qry = "select p from Person p ";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		List<Person> persons = q.getResultList();
		for(Person p:persons) {
			System.out.println(p);
		}
		
	}

}
