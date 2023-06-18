package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Department;

public class FetchDeptByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dept name to display the details");
		String name = sc.next();
		String qry = "select d from Department d where d.name = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Department> dept = q.getResultList();
		for(Department d:dept) {
			System.out.println("Id - "+d.getId());
			System.out.println("Location -" +d.getLocation());
		}
	}

}
