package com.pborrego.hexagonalarchitecture.products.application.usecases;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.util.StringUtils;

import com.pborrego.hexagonalarchitecture.products.application.commands.ProductCreationCommand;
import com.pborrego.hexagonalarchitecture.products.application.ports.input.ProductCreationInputPort;
import com.pborrego.hexagonalarchitecture.products.application.ports.output.ProductPersistenceOutputPort;
import com.pborrego.hexagonalarchitecture.products.domain.exceptions.ProductAlreadyExistsException;
import com.pborrego.hexagonalarchitecture.products.domain.model.Product;

public class ProductCreationUseCase implements ProductCreationInputPort {

	private final ProductPersistenceOutputPort productPersistenceOutputPort;
	
	public ProductCreationUseCase(ProductPersistenceOutputPort productPersistenceOutputPort) {
		super();
		this.productPersistenceOutputPort = productPersistenceOutputPort;
	}

	@Override
	public Product createProduct(ProductCreationCommand productCreationCommand) throws ProductAlreadyExistsException {
		
		// Command Variables
		String desiredName = productCreationCommand.getName();
		BigDecimal desiredPrice = productCreationCommand.getPrice();
		
		// Validations of Command Inputs
		if(!StringUtils.hasText(desiredName)) {
			throw new IllegalArgumentException("Product name can't be empty");
		}
		
		if (desiredPrice == null) {
			throw new IllegalArgumentException("Product price can't be null");
		}
		
		if (desiredPrice.scale() > 2) {
			throw new IllegalArgumentException("Product price scale can't be bigger than 2");
		}
		
		if (desiredPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Product price has to be bigger than 0.00");
        }
		
		Optional<Product> possibleExistingProduct = productPersistenceOutputPort.findProductByName(desiredName);
		if(possibleExistingProduct.isPresent()) {
			String errorMessage = String.format("Product with name [%s] already exists", desiredName);
			throw new ProductAlreadyExistsException(errorMessage);
		}
		
		Product productToCreate = new Product(UUID.randomUUID(), desiredName, desiredPrice);
		return productPersistenceOutputPort.create(productToCreate);
		
	}

}
