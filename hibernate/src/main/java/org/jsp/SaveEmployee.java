package org.jsp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {
	public static void main(String[] args) {
		Employee e  = new Employee();
		e.setName("shramjikalonda");
		e.setDesg("businessman");
		e.setSalary(100000);
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		s.save(e);
		Transaction t = s.beginTransaction();
		t.commit();
		System.out.println("employee saved with id " + e.getId());
		
	}

}
