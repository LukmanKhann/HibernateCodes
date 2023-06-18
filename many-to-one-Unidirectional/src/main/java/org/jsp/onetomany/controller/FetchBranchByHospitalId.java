package org.jsp.onetomany.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomay.dto.Branch;

public class FetchBranchByHospitalId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Hospital id to display Branch details");
		int id = sc.nextInt();
		String qry = "select b from Branch b where b.hospital.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		List<Branch> branches = q.getResultList();
		if(branches.size()>0) {
			for(Branch b:branches) {
				System.out.println("Name - "+b.getName());
				System.out.println("Email - "+b.getEmail());	
				System.out.println("Phone - "+b.getPhone());
			   System.out.println("----------------------------");
			}
			
		}
		else {
			System.err.println("Entered Hopital id is invalid ");
		}
	}

}
