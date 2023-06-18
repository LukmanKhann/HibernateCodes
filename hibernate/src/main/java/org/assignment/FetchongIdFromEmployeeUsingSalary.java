package org.assignment;

import java.util.Scanner;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchongIdFromEmployeeUsingSalary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Salary to display employee Id");
		double  salary = sc.nextDouble();
		String qry = "select e.id from Employee e where e.salary = ?1";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
         Query<Integer> q = s.createQuery(qry);
         q.setParameter(1, salary);
         try {
         Integer e = q.getSingleResult();
         System.out.println(e);
         }
         catch(ClassCastException e) {
        	 System.err.println("Abnormal Error Check And Try Again Later");
         }
         catch(NonUniqueResultException e) {
        	 System.err.println("Error due to  Multiple Salary Found can not fetch the ID");
         }
         catch(NoResultException e) {
        	 System.err.println("Entered Salary is Not Present");
         }
        
	}

}
