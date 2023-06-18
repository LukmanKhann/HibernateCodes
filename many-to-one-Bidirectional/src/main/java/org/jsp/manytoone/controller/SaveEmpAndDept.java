  	
 package org.jsp.manytoone.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Transaction;
import org.jsp.manytoone.dto.Department;
import org.jsp.manytoone.dto.Employee;

public class SaveEmpAndDept {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Department d = new Department();
		d.setName("Development");
		d.setLocation("BTM Layout");
		
		Employee e1 = new Employee();
		e1.setDesg("Trainer");
		e1.setName("ABC");
		e1.setSalary(44506);
		e1.setDept(d);
		
		Employee e2 = new Employee();
		e2.setDesg("HR");
		e2.setName("XYZ");
		e2.setSalary(77806);
		e2.setDept(d);
		
		Employee e3 = new Employee();
		e3.setDesg("Supporter");
		e3.setName("PQR");
		e3.setSalary(69636);
		e3.setDept(d);
		
		EntityTransaction transaction = manager.getTransaction();
		d.setEmps(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)));
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		
		
	}

}
