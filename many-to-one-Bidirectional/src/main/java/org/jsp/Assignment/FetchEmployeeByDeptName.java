package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Department;
import org.jsp.manytoone.dto.Employee;

import com.mysql.cj.QueryAttributesBindings;

public class FetchEmployeeByDeptName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Dept Name to display the emps details");
		String name = sc.nextLine();
		String qry = "select d from Department d where d.name = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		try {
			Department d  = (Department) q.getSingleResult();
			List<Employee> emps = d.getEmps();
			for(Employee e:emps) {
				System.out.println("Name - "+e.getName());
				System.out.println("Designation -"+e.getDesg());
				System.out.println("Salary -"+e.getSalary());
			System.out.println("-------------------------------");
			}
		}
		catch(NoResultException e ) {
			System.err.println("Enter Dept name is invalid");
		}
	}

}
