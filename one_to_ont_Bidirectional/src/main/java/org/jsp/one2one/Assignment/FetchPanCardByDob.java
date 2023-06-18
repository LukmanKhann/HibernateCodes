package org.jsp.one2one.Assignment;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one.dto.PanCard;

public class FetchPanCardByDob {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter DOB to Fetch Pancard Details");
		String dob = sc.next();
		LocalDate date = LocalDate.parse(dob);
		String qry = "select pc from PanCard pc where pc.dob = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	  Query q = manager.createQuery(qry);
	  q.setParameter(1, date);
	  try {
		  PanCard pancard = (PanCard)q.getSingleResult();
		  System.out.println("Id - "+pancard.getId());
			System.out.println("PinCode  -"+pancard.getPincode());
			System.out.println("Number  - "+pancard.getNumber());
	  }
	  catch(NoResultException e ) {
		  System.err.println("Entered Number is Invalid");
	  }
	  catch(NonUniqueResultException e) {
		  System.err.println("Duplicate Insertion Error");
	  }
	
		
		
	}

}
