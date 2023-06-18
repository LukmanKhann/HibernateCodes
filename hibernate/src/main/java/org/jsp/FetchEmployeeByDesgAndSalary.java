package org.jsp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchEmployeeByDesgAndSalary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Designation and salary to display details");
		String desg = sc.nextLine();
		double salary = sc.nextDouble();
		String qry = "select e from Employee e where e.desg = ?1 and e.salary = ?2";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
         Query<Employee> q = s.createQuery(qry);
         q.setParameter(1, desg);
         q.setParameter(2, salary);
         List<Employee> emps = q.getResultList();
         if(emps.size()>0) {
        	 for(Employee e:emps) {
        		 System.out.println(e);
        	 }
         }
         else {
        	 System.out.println("No employee found with that details");
         }
	}

}
