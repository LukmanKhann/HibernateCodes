package org.assignment;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.Employee;

public class FetchingEmployeeNameUsingDesignation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter designation to display employee name");
		String desg = sc.next();
		String qry = "select e.name from Employee e where e.desg = ?1";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
         Query<String> q = s.createQuery(qry);
         q.setParameter(1, desg);
         try {
         String e = q.getSingleResult();
         System.out.println(e);
         }
         catch(Throwable e) {
        	 System.err.println("Designation not matching any Name in the Employee Table!!!");
         }
        
	}

}
