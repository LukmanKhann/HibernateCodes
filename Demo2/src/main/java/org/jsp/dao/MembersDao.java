package org.jsp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsp.dto.Members;

public class MembersDao {
	public static Members savemember(Members member) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		s.save(member);
		Transaction t = s.beginTransaction();
		t.commit();
		return member;
		
	}
	public static Members updatemember(Members member) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
         s.update(member);
         Transaction t = s.beginTransaction();
         t.commit();
         return member;
	}
	public static Members findmember(int id) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
        return s.find(Members.class, id);
		
	}
	public boolean  deletemember(int id) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
        Members m = findmember(id);
        if(m!=null) {
        	s.delete(m);
        	Transaction t = s.beginTransaction();
        	t.commit();
        	return true;
        }
        return false;
		
	}

}
