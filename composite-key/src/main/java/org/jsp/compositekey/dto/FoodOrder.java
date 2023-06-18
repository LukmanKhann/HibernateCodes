 package org.jsp.compositekey.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private double cost ;
	private String food_item;
	@CreationTimestamp
  private LocalDate ordr_time;
	@UpdateTimestamp
	 private LocalDate delivery_time;
	
	public LocalDate getOrdr_time() {
		return ordr_time;
	}
	public void setOrdr_time(LocalDate ordr_time) {
		this.ordr_time = ordr_time;
	}
	public LocalDate getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(LocalDate delivery_time) {
		this.delivery_time = delivery_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getFood_item() {
		return food_item;
	}
	public void setFood_item(String food_item) {
		this.food_item = food_item;
	}
	

}
