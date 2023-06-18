package org.jsp;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your employee id to update the details");
		int id = sc.nextInt();
		System.out.println("Enter your name,designation and salary");
		String name = sc.next();
		String desg = sc.next();
		double salary = sc.nextDouble();
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setDesg(desg);
		e.setSalary(salary);
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(e);
		t.commit();
	}

}
