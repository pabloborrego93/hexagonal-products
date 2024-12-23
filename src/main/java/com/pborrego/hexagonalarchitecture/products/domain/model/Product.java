package com.pborrego.hexagonalarchitecture.products.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

	private UUID uuid;
	private String name;
	private BigDecimal price;
	
	public Product() {
		super();
	}

	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(UUID uuid, String name, BigDecimal price) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.price = price;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
