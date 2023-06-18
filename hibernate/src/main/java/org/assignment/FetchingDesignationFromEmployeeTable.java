package org.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchingDesignationFromEmployeeTable {
	public static void main(String[] args) {
		String qry = "select e.desg from Employee e";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<String> q = s.createQuery(qry);
		List<String> desg= q.getResultList();
		for(String e:desg) {
			System.out.println(e);
		}
	}

}
