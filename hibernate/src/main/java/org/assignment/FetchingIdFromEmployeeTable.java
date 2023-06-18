 package org.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.Employee;

public class FetchingIdFromEmployeeTable {
	public static void main(String[] args) {
		String qry = "select e.id from Employee e";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<Integer> q = s.createQuery(qry);
		List<Integer> id= q.getResultList();
		for(Integer e:id) {
			System.out.println(e);
		}
	}

}
