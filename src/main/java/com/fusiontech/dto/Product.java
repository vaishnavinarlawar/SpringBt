package com.fusiontech.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_db")
public class Product {

	@Id
	@Column
	private int id;

	@Column
	private String name;
	@Column
	private String status;

	@JoinColumn(name = "product_id", referencedColumnName = "id")
	@OneToMany(targetEntity = ProductDetails.class, cascade = CascadeType.ALL)
	private List<ProductDetails> pd;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProductDetails> getPd() {
		return pd;
	}

	public void setPd(List<ProductDetails> pd) {
		this.pd = pd;
	}

	
	
	
}
		

	