package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Department;
import org.jsp.manytoone.dto.Employee;

public class FetchDeptByEmpName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name to display the Dept details");
		String name  = sc.next();
		String qry = "select e from Employee e where e.name = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		try {
			Employee e = (Employee)q.getSingleResult();
			Department d = e.getDept();
			System.out.println("ID" + d.getId());
			System.out.println("Name -" +d.getName());
			System.out.println("Location - "+d.getLocation());
		}
		catch (NoResultException e) {
		    System.err.println("Invalid name !!!!");
		}
		
	}

}
