package org.jsp.one2one.Assignment;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one.dto.PanCard;

public class FetchPanCardByDob_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dob to fetch the pan card details");
		LocalDate dob = LocalDate.parse(sc.next());
		String qry = "select p from PanCard p where p.dob=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, dob);
		List<PanCard> pan = q.getResultList();
		for(PanCard p:pan) {
			System.out.println(p);
		}
	}

}
