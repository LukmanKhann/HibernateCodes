package org.jsp.manytomany.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.mantomany.dto.Batch;
import org.jsp.mantomany.dto.Student;



public class SaveBatchAndStudent {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Batch b1 = new Batch();
		b1.setSubject("Hibernate");
		b1.setCode("SEHE5");
		
		Batch b2 = new Batch();
		b2.setSubject("Spring Boot");
		b2.setCode("SEHEJ5");
		
		Batch b3 = new Batch();
		b3.setSubject("J2EE");
		b3.setCode("SEJC37");
		
		Student s1 = new Student();
		s1.setName("lukman");
		s1.setPerc(66);
		s1.setPhone(797496490);
		
		Student s2 = new Student();
		s2.setName("Saif");
		s2.setPerc(98);
		s2.setPhone(747063156);
		
		Student s3 = new Student();
		s3.setName("Kaif");
		s3.setPerc(88);
		s3.setPhone(606065659);
		
//		Assigning the the student for b1
		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
//		Assigning the the student for b2
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
//		Assigning the the student for b3
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		transaction.begin();
		transaction.commit();

 
	}

}
