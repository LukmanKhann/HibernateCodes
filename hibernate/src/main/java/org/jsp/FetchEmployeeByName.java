package org.jsp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchEmployeeByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name to display employee details");
		String name = sc.next();
		String hql = "select e from Employee e where e.name =:nm";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q = s.createQuery(hql);
		q.setParameter("nm",name);
		List<Employee> emps = q.getResultList();
		if(emps.size()>0) {
			for(Employee e:emps) {
				System.out.println(e);
			}
		}
		else {
			System.out.println("no Empoyee is found with this name ");
		}
	}

}
