package com.pborrego.hexagonalarchitecture.products.application.ports.output;

import java.util.Optional;
import java.util.UUID;

import com.pborrego.hexagonalarchitecture.products.domain.model.Product;

public interface ProductPersistenceOutputPort {

    Product create(Product product);
    Optional<Product> findProductByUUID(UUID uuid);
    Optional<Product> findProductByName(String name);
	
}
