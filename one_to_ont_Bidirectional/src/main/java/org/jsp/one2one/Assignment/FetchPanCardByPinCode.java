package org.jsp.one2one.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one.dto.PanCard;

public class FetchPanCardByPinCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PinCode to Fetch Pancard");
		int pincode = sc.nextInt();
		String qry = "select pc from PanCard pc where pc.pincode = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	  Query q = manager.createQuery(qry);
	  q.setParameter(1, pincode);
	  try {
		  PanCard pancard = (PanCard)q.getSingleResult();
		  System.out.println("Id - "+pancard.getId());
			System.out.println("Number  -"+pancard.getNumber());
			System.out.println("DateOfBirth  - "+pancard.getDob());
	  }
	  catch(NoResultException e ) {
		  System.err.println("Entered Number is Invalid");
	  }
	  catch(NonUniqueResultException e) {
		  System.err.println("Duplicate Insertion Error");
	  }
	
		
		
	}

}
