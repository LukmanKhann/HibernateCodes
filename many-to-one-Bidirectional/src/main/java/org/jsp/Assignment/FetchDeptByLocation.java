package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Department;

public class FetchDeptByLocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dept Location to display the details");
		String location = sc.nextLine();
		String qry = "select d from Department d where d.location = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, location);
		List<Department> dept = q.getResultList();
		for(Department d:dept) {
			System.out.println("Id - "+d.getId());
			System.out.println("name -" +d.getName());
		}
	}
}
