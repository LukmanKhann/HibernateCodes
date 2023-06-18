package org.jsp.one2one.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.one2one.dto.PanCard;
import org.jsp.one2one.dto.Person;

public class FetchPanCardByPerson_Id {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person id to fetch the PanCard");
		int pancardid = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, pancardid);
		if(p!=null) {
			PanCard card = p.getCard();
			System.out.println("Pincode - "+card.getPincode());
			System.out.println("Number  - "+card.getNumber());	
			System.out.println("DOB  - "+card.getDob());
		}
		else {
			System.err.println("You are intered invalid Person Id");
		}
	}

}
