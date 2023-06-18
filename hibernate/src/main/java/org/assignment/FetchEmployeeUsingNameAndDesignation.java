 package org.assignment;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.Employee;

public class FetchEmployeeUsingNameAndDesignation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name and designation to display the employee details");
		String name = sc.nextLine();
		String desg = sc.nextLine();
		String qry = "select e from Employee e where name = ?1 and desg = ?2";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q = s.createQuery(qry);
		q.setParameter(1, name);
		q.setParameter(2, desg);
		List<Employee> emps = q.getResultList();
		if(emps.size()>0) {
			for(Employee e:emps) {
				System.out.println(e);
			}
		}
		else {
			System.err.println("no record matching this name and designation");
		}
	}

}
