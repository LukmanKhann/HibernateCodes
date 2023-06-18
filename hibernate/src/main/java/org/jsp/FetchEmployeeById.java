package org.jsp;

 import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchEmployeeById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter ID to display the details");
		int eid = sc.nextInt();
		String qry = "select e from Employee e where e.id=?1";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
	Query<Employee> q = s.createQuery(qry);
	q.setParameter(1, eid);
	try {
		Employee e = q.getSingleResult();
		System.out.println(e);
	}
	catch(NoResultException e) {
		System.err.println("you have enterd invalid ID");
	}
	}

}
