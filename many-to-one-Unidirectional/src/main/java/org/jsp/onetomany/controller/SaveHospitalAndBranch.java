package org.jsp.onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomay.dto.Branch;
import org.jsp.onetomay.dto.Hospital;

public class SaveHospitalAndBranch {
public static void main(String[] args) {
	     Hospital h = new Hospital();
	     h.setName("Apollo");
	     h.setGst("Apollo123");
	     h.setFounder("ABC");
	     
	     Branch b1 = new Branch();
	     b1.setName("Banglore Apollo Hospital");
	     b1.setEmail("Apollo@gmail.com");
	     b1.setPhone(777);
	     b1.setHospital(h);
	     
	     Branch b2 = new Branch();
	     b2.setName("Manglore Apollo Hospital");
	     b2.setEmail("Apollo112@gmail.com");
	     b2.setPhone(888);
	     b2.setHospital(h);
	     
	     Branch b3 = new Branch();
	     b3.setName("Maysore Apollo Hospital");
	     b3.setEmail("Apollo223@gmail.com");
	     b3.setPhone(999);
	     b3.setHospital(h);
	     
           EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
           EntityTransaction transaction = manager.getTransaction();
           manager.persist(b1);
           manager.persist(b2);
           manager.persist(b3);
           transaction.begin();
           transaction.commit();
}
}
