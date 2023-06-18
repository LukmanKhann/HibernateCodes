package org.jsp.onetomay.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name,founder;
private String gst;
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
public String getFounder() {
	return founder;
}
public void setFounder(String founder) {
	this.founder = founder;
}
public String getGst() {
	return gst;
}
public void setGst(String gst) {
	this.gst = gst;
}

}
