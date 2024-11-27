package com.pborrego.hexagonalarchitecture.products.domain.model;

import java.util.UUID;

public class Product {

	private UUID id;
	private String name;
	private Double price;
	
	public Product() {
		super();
	}

	public Product(UUID id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
