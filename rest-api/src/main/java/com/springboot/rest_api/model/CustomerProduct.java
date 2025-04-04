package com.springboot.rest_api.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomerProduct 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Customer customer;//findByCustomerId -- this custom method 
	@ManyToOne
	private Product product;//findByProductId
	
	private LocalDate dateofpurchase;//findByDateofPurchase
//	@ColumnDefault(value = "1")
	private int quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public LocalDate getDateofpurchase() {
		return dateofpurchase;
	}
	public void setDateofpurchase(LocalDate localDate) {
		this.dateofpurchase = localDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
