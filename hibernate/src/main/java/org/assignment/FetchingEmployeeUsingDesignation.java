package org.assignment;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.Employee;

public class FetchingEmployeeUsingDesignation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Designation to display Employee Details");
		String desg = sc.next();
		String qry = "select e from Employee e where e.desg = ?1";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q = s.createQuery(qry);
		q.setParameter(1, desg);
		List<Employee>emps = q.getResultList();
		if(emps.size()>0) {
			for(Employee e:emps) {
				System.out.println(e);
			}
		}
		else {
			System.err.println("There is no record matching entered designation");
		}
	}


}
