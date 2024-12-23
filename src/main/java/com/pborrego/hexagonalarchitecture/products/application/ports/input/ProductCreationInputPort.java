package com.pborrego.hexagonalarchitecture.products.application.ports.input;

import com.pborrego.hexagonalarchitecture.products.application.commands.ProductCreationCommand;
import com.pborrego.hexagonalarchitecture.products.domain.exceptions.ProductAlreadyExistsException;
import com.pborrego.hexagonalarchitecture.products.domain.model.Product;

public interface ProductCreationInputPort {

	Product createProduct(ProductCreationCommand productCreationCommand) throws ProductAlreadyExistsException;
	
}
