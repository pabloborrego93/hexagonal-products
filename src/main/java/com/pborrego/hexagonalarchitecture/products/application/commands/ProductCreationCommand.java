package com.pborrego.hexagonalarchitecture.products.application.commands;

import java.math.BigDecimal;

public class ProductCreationCommand {

	private String name;
	private BigDecimal price;
	
	public ProductCreationCommand() {
		super();
	}

	public ProductCreationCommand(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
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
