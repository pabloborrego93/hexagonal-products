package com.pborrego.hexagonalarchitecture.products.infastructure.adapters.output.jpa;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class ProductDatabaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, updatable = false, length = 36)
	private UUID uuid;
	@Column(unique = true, updatable = true, length = 128)
	private String name;
	@Column(scale = 2)
	private BigDecimal price;
	
	public ProductDatabaseEntity() {
		super();
	}

	public ProductDatabaseEntity(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public ProductDatabaseEntity(UUID uuid, String name, BigDecimal price) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
