 package org.assignment;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.Employee;

public class FetchingEmployeeSalaryUsingId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to display employee salary");
		int id = sc.nextInt();
		String qry = "select e.salary from Employee e where e.id = ?1";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
         Query<Double> q = s.createQuery(qry);
         q.setParameter(1, id);
         try {
         Double e = q.getSingleResult();
         System.out.println(e);
         }
         catch(Throwable e) {
        	 System.err.println("No salaru Found with this id");
         }
	}

}
