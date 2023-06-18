package org.jsp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsp.dto.Details;

public class DetailsDao {
	public Details savedetails(Details detail) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(detail);
		t.commit();
		return detail;
	}
	public Details updatedetails(Details detail) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		s.update(detail);
		Transaction t = s.beginTransaction();
		t.commit();
		return detail;
	}
	public Details finduser (int id) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
       return  s.find(Details.class, id );
	}
	public boolean deleteuser(int id) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
       Details d = finduser(id);
       if(d!=null) {
    	   s.delete(d);
    	   Transaction t = s.beginTransaction();
    	   t.commit();
    	   return true;
       }
       return false;
		
	}

}
