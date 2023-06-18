 package org.assignment;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.Employee;

public class FetchingEmployeeUsingSalary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Salary to display employee Details");
		double salary = sc.nextDouble();
		String qry = "select e from Employee e where e.salary = ?1";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q = s.createQuery(qry);
		q.setParameter(1, salary);
		List<Employee> emps = q.getResultList();
		if(emps.size()>0) {
			for(Employee e:emps) {
				System.out.println(e);
			}
		}
		else {
			System.err.println("there is not records matching this salary");
		}
		
	}

}
