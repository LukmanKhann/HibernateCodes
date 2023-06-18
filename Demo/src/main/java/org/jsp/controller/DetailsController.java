package org.jsp.controller;

import java.util.Scanner;

import org.jsp.dao.DetailsDao;
import org.jsp.dto.Details;

public class DetailsController {
static	Scanner sc = new Scanner(System.in);
	static DetailsDao dao = new DetailsDao();
	public static void main(String[] args) {
		System.out.println("1.Register User");
		System.out.println("2.Edit Your Details");
		System.out.println("3.Find User By Id");
		System.out.println("4.Delete User");
		int num = sc.nextInt();
		switch (num) {
		case 1:{
			save();
			
			break;
		}
		case 2:{
			update();
			 break;
		}
		case 3:{
			finduser();
			break;
		}
		case 4:{
			deleteuser();
			break;
		}
		}
	}
	public static void save() {
		System.out.println("Enter your name,email and phone");
		String name = sc.next();
		String email = sc.next();
		long phone = sc.nextLong();
		Details d = new Details();
		d.setName(name);
		d.setEmail(email);
		d.setPhone(phone);
		d = dao.savedetails(d);
		System.out.println("Registration successfull");
	}
	public static void update() {
		System.out.println("Enter your id to update the data");
		int id = sc.nextInt();
		System.out.println("Enter your name ,email and phone to update");
		String name = sc.next();
		String email = sc.next();
		long phone = sc.nextLong();
		Details d = new Details();
		d.setId(id);
		d.setName(name);
		d.setEmail(email);
		d.setPhone(phone);
		d=dao.updatedetails(d);
		System.out.println("data updated successfully");
		
	}
	public static void finduser() {
		System.out.println("Enter Id to Find The User");
		int id = sc.nextInt();
		Details d = new Details();
		d = dao.finduser(id);
	    System.out.println(d);
	}
	public static void deleteuser() {
		System.out.println("enter id to delete the user");
		int id = sc.nextInt();
		Details d = new Details();
		dao.deleteuser(id);
		System.out.println("Id deleted successfully");
		
	}
		
	}


