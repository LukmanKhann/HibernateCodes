package org.jsp.one2one.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.one2one.dto.PanCard;
import org.jsp.one2one.dto.Person;

public class FetchPersonByPanCard_Id_1 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Pancard id to fetch the Person");
	int pancardid = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	PanCard card = manager.find(PanCard.class, pancardid);
	if(card!=null) {
		Person p = card.getP();
		System.out.println("name - "+p.getName());
		System.out.println("Age - "+p.getAge());	
		System.out.println("Phone - "+p.getPhone());
	}
	else {
		System.err.println("You are intered invalid PanCard Id");
	}
}

}
