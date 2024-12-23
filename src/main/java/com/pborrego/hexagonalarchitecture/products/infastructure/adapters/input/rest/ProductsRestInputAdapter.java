package com.pborrego.hexagonalarchitecture.products.infastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pborrego.hexagonalarchitecture.products.application.commands.ProductCreationCommand;
import com.pborrego.hexagonalarchitecture.products.application.ports.input.ProductCreationInputPort;
import com.pborrego.hexagonalarchitecture.products.domain.exceptions.ProductAlreadyExistsException;
import com.pborrego.hexagonalarchitecture.products.domain.model.Product;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsRestInputAdapter {

	private final ProductCreationInputPort productCreationInputPort;
	
	public ProductsRestInputAdapter(ProductCreationInputPort productCreationInputPort) {
		super();
		this.productCreationInputPort = productCreationInputPort;
	}

	@PostMapping
	Product createProduct(@RequestBody @Valid ProductCreationRestRequest productCreationRestRequest) throws ProductAlreadyExistsException {
		ProductCreationCommand productCreationCommand = new ProductCreationCommand(productCreationRestRequest.name(), productCreationRestRequest.price());
		return productCreationInputPort.createProduct(productCreationCommand);
	}
	
}
