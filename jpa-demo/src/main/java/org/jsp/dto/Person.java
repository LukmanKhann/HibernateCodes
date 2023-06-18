package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="person")
@NamedQuery(name = "FindByAge", query = "select p from Person p where p.Age = ?1")
@NamedQuery(name = "FindByPhone",query = "select p from Person p where p.Phone = ?1")
@NamedQuery(name = "FindByEmail",query = "select p from Person p where p.Email=?1")
@NamedQuery(name = "FindByName" , query = "select p from Person p where p.Name=?1")
@NamedQuery(name = "FetchAgeById",query = "select p.Age from Person p where p.id=?1")
@NamedQuery(name = "FetchIdByName",query = "select p.id from Person p where p.Name=?1")
@NamedQuery(name = "FetchPhoneByName", query = "select p.Phone from Person p where p.Name=?1" )
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@Column(nullable = false)
	private String Name;
	@Column(nullable = false)
	private int Age;
	@Column(nullable = false,unique = true)
	
	private String Email;
	@Column(nullable = false,unique = true)
	private long Phone;
	@Column(nullable = false)
	private String Password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", Name=" + Name + ", Age=" + Age + ", Email=" + Email + ", Phone=" + Phone
				+ ", Password=" + Password + "]";
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

}
