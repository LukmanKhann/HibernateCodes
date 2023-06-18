package org.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchingSalaryFormEmployeeTable {
	public static void main(String[] args) {
		String qry = "select e.salary from Employee e";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<Double> q = s.createQuery(qry);
		List<Double> salary= q.getResultList();
		for(Double e:salary) {
			System.out.println(e);
		}
	}

}
