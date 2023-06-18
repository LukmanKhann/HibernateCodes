package org.jsp.controller;

import java.util.Scanner;

import org.jsp.dao.MembersDao;
import org.jsp.dto.Members;

public class MemberController {
	static Scanner sc = new Scanner(System.in);
  static	 MembersDao dao = new MembersDao();
  public static void main(String[] args) {
	System.out.println("1 - Registration");
	System.out.println("2 - Update the member");
	System.out.println("3 - Find the member");
	System.out.println("4 - Delete the member");
	int choice = sc.nextInt();
	switch (choice) {
	case 1:{
		save();
		break;
	}
case 2:{
	update();
		
		break;
	}
case 3:{
	find();
	break;
}
case 4:{
	delete();
	break;
}
	
	}
}
  
  public static void save() {
	  System.out.println("Enter your Name,Age,Salary and Phone");
	  String name = sc.next();
	  int age = sc.nextInt();
	  double salary = sc.nextDouble();
	  long phone = sc.nextLong();
	  Members m = new Members();
	  m.setName(name);
	  m.setAge(age);
	  m.setSalary(salary);
	  m.setPhone(phone);
	  m = dao.savemember(m);
	  System.out.println("Registration successfull");
  }
  public static void update() {
	  System.out.println("Enter yout id to update the member details");
	  int id = sc.nextInt();
	  System.out.println("Enter New - Name,Age,Salary and Phone ");
	  String name = sc.next();
	  int age = sc.nextInt();
	  double salary = sc.nextDouble();
	  long phone = sc.nextLong();
	  Members m = new Members();
	  m.setId(id);
	  m.setName(name);
	  m.setAge(age);
	  m.setSalary(salary);
	  m.setPhone(phone);
       m = dao.updatemember(m);
       System.out.println("details Updated successfully");
	  
  }
  public static void find() {
	  System.out.println("Enter your Id to find the Member");
	  int id = sc.nextInt();
	  Members m = new Members();
	  m = dao.findmember(id);
	  System.out.println(m);
  }
  public static void delete() {
	  System.out.println("Enter Id to Delete The Member");
	  int id = sc.nextInt();
	  Members m = new Members(); 
		  dao.deletemember(id);
		  System.out.println("Member Deleted Successfully");
		  
	 
  }

}
