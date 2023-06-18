package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytoone.dto.Department;
import org.jsp.manytoone.dto.Employee;

public class FetchEmployeeByDeptId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dept id to display emp details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Department d = manager.find(Department.class, id);
		if(d!=null) {
			List<Employee> emps = d.getEmps();
		     for(Employee e:emps) {
		    		System.out.println("Name - "+e.getName());
					System.out.println("Designation -"+e.getDesg());
					System.out.println("Salary -"+e.getSalary());
					System.out.println("------------------------------");
		     }
		}
		else {
			System.err.println("invalid Dept id");
		}
	}

}
