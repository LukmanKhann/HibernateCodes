 package org.assignment;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.Employee;

public class FetchingEmployeeUsingIdAndName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Id and Name to display Employee Details");
		String name = sc.nextLine();
		int id = sc.nextInt();
		String qry = "select e from Employee e where e.name = ?1 and e.id = ?2";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
      Query<Employee> q = s.createQuery(qry);
      q.setParameter(1, name);
      q.setParameter(2, id);
      List<Employee> emps = q.getResultList();
      if(emps.size()>0) {
    	  for(Employee e:emps) {
    		  System.out.println(e);
    	  }
      }
      else {
    	  System.err.println("No record matching this name and Id");
      }
      
	}

}
