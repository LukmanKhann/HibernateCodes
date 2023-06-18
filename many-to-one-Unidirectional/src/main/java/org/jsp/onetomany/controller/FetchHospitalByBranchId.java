package org.jsp.onetomany.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomay.dto.Hospital;

public class FetchHospitalByBranchId {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Branch Id to display Hospital");
	int bid = sc.nextInt();
	String qry = "select b.hospital from Branch b where b.id=?1";
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, bid);
	try {
		Hospital h = (Hospital) q.getSingleResult();
		System.out.println("Name-"+h.getName());
		System.out.println("Founder - "+h.getFounder());
		System.out.println("GST - "+h.getGst());
	}
	catch(NoResultException e) {
		System.err.println("Entered Branch Id is invalid");
	}
}
}
