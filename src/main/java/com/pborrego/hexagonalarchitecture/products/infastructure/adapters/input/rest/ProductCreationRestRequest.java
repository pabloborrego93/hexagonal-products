package com.pborrego.hexagonalarchitecture.products.infastructure.adapters.input.rest;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ProductCreationRestRequest(

	@NotEmpty
	@Size(min = 2, max = 128)
	String name,
	
	@NotNull
	@DecimalMax("2")
	BigDecimal price

) {}