package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Employee;

public class FetchEmployeeBySalary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Emp salary to display Emp details");
		double salary = sc.nextDouble();
		String qry = "select e from Employee e where e.salary = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, salary);
		List<Employee> emp = q.getResultList();
		for(Employee e:emp) {
			System.out.println("Name - "+e.getName());
			System.out.println("Designation -"+e.getDesg());
			System.out.println("Salary -"+e.getSalary());
		}
	}

}
