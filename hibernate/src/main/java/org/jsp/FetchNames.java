package org.jsp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchNames {
	public static void main(String[] args) {
		Session s= new Configuration().configure().buildSessionFactory().openSession();
        String qry = "select e.name from Employee e";
        Query<String> q = s.createQuery(qry);
        List<String> names = q.getResultList();
        for(String name:names) {
        	System.out.println(name);
        }
	}

}
