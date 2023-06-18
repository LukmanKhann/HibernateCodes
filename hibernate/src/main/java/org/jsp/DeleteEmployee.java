package org.jsp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id");
		int eid = sc.nextInt();
		Employee e = s.get(Employee.class, eid);
		if(e!=null) {
			s.delete(e);
			System.out.println("Record is deleted successfully");
			t.commit();
		}
		else {
			System.err.println("something is wrong invalid Id");
		}
		
	}

}
