package org.assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Person;

public class FetchPersonByIdAndPassword {
	public static void main(String[] args) {
		System.out.println("Enter Person Id and Password To display person details ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		String passowrd = sc.next();
		String qry = "select p from Person p where p.id = ?1 and p.Password = ?2";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery (qry);
		q.setParameter(1, id);
		q.setParameter(2, passowrd);
		try {
		Person p = (Person)q.getSingleResult();
		System.out.println("login successfull");
		System.out.println(p);
		}
		catch(NoResultException e ) {
			System.out.println("entered id password is invalid");
		}
	}

}
