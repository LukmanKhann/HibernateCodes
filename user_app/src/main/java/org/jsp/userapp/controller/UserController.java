package org.jsp.userapp.controller;

import java.util.Scanner;

import org.jsp.userapp.dto.User;
import org.jsp.userappp.dao.UserDao;

public class UserController {
	static Scanner sc = new Scanner(System.in);
	static UserDao dao = new UserDao();
	public static void main(String[] args) {
		System.out.println("1.Register User");
		System.out.println("2.Edit Your Details");
		System.out.println("3.Find User By Id");
		System.out.println("4.Delete User");
		System.out.println("5.Verify User By Phone and Password");
		System.out.println("6.Verify User By Email and password");
		System.out.println("7.Verify User By id and password");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: {
			save();
			break;
			
		}
         case 2: {
        	 update();
        	 break;
			
		}
         case 3: {
        	 find();
        	 break;
			
		}
         case 4: {
        	 delete();
        	 break;
			
		}
         case 5: {
        	 VerifyUserByPhoneAndPass();
        	 break;
        	 
			
		}
         case 6: {
        	 VerifyUserByEmailAndPass();
			break;
			
		}
         case 7: {
        	 VerifyUserByIdAndPass();
        	 break;
        	 
			
		}
		}
		
	}
	public static void save() {
		System.out.println("Enter your name,email,gender,phone and Password");
		String name = sc.next();
		String email = sc.next();
		String gender = sc.next();
		long phone = sc.nextLong();
		String password = sc.next();
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setGender(gender);
		u.setPhone(phone);
		u.setPassword(password);
		u = dao.saveUser(u);
		System.out.println("you are registered Successfully with id " +u.getId());
		
	}
	public static void update() {
		System.out.println("Enter Your ID");
		int id = sc.nextInt();
		System.out.println("Enter Your Name,email,gender,phone and password");
		String name = sc.next();
		String email = sc.next();
		String gender = sc.next();
		long phone = sc.nextLong();
		String password = sc.next();
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setGender(gender);
		u.setPhone(phone);
		u.setPassword(password);
		u = dao.updateUser(u);
		System.out.println("your account Updated");
	}
	public static void find () {
		System.out.println("Enter Your ID to Show Details ");
		int id = sc.nextInt();
		User u = new User();
		u = dao.findUserById(id);
		System.out.println(u.getName());
		System.out.println(u.getEmail());
		System.out.println(u.getGender());
		System.out.println(u.getPhone());
		System.out.println(u.getPassword());
		
	}
	public static void delete() {
		System.out.println("Enter id to delete record");
		int id = sc.nextInt();
		User u = new User();
		dao.DeleteUser(id);
		System.out.println("Record is Deleted Successfully");
		
		
	}
	public static void VerifyUserByPhoneAndPass() {
		System.out.println("Enter Phone and Password to Verify User ");
		long phone = sc.nextLong();
		String password = sc.next();
		User u = new User();
		u = dao.VerifyUser(phone, password);
		System.out.println(u.getName());
		System.out.println(u.getId());
		System.out.println(u.getGender());
		System.out.println(u.getEmail());
		
	}
	public static void VerifyUserByEmailAndPass() {
		System.out.println("Enter Email and Password to Verify User ");
		String email = sc.next();
		String password = sc.next();
		User u = new User();
		u = dao.VerifyUser(email, password);
		System.out.println(u.getName());
		System.out.println(u.getId());
		System.out.println(u.getGender());
		System.out.println(u.getPhone());
		
	}
	public static void VerifyUserByIdAndPass() {
		System.out.println("Enter Id and Password to Verify User ");
		int id = sc.nextInt();
		String password = sc.next();
		User u = new User();
		u = dao.VerifyUser(id, password);
		System.out.println(u.getName());
		System.out.println(u.getEmail());
		System.out.println(u.getGender());
		System.out.println(u.getPhone());
//		System.out.println(u);
		
	}

}
