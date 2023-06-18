package org.jsp;

public class Employee {
private int id;
private String name,desg;
private double salary;
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", desg=" + desg + ", salary=" + salary + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesg() {
	return desg;
}
public void setDesg(String desg) {
	this.desg = desg;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}
