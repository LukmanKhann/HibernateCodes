package org.jsp.one2one.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.one2one.dto.PanCard;
import org.jsp.one2one.dto.Person;

public class FetchPanCardById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to Fetch Pancard");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	   PanCard pancard = manager.find(PanCard.class, id);
	if(pancard!=null) {
		System.out.println("Number - "+pancard.getNumber());
		System.out.println("PinCode  -"+pancard.getPincode());
		System.out.println("DateOfBirth  - "+pancard.getDob());
		
	}
	else {
		System.err.println("Your Entered Id is wrong");
	}
		
		
	}
	

}
