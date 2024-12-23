package com.pborrego.hexagonalarchitecture.products.infastructure.adapters.output.jpa;

import java.util.Optional;
import java.util.UUID;

import com.pborrego.hexagonalarchitecture.products.application.ports.output.ProductPersistenceOutputPort;
import com.pborrego.hexagonalarchitecture.products.domain.model.Product;

public class ProductsPersistenceJpaOutputAdapter implements ProductPersistenceOutputPort {

	private final ProductsJpaRepository productsJpaRepository;

	public ProductsPersistenceJpaOutputAdapter(ProductsJpaRepository productsJpaRepository) {
		this.productsJpaRepository = productsJpaRepository;
	}
	
	@Override
	public Product create(Product product) {
		ProductDatabaseEntity productToSave = new ProductDatabaseEntity(product.getUuid(), product.getName(), product.getPrice());
		ProductDatabaseEntity savedProduct = productsJpaRepository.save(productToSave);
		return new Product(savedProduct.getUuid(), savedProduct.getName(), savedProduct.getPrice());
	}
	
	@Override
	public Optional<Product> findProductByUUID(UUID uuid) {
		return productsJpaRepository.findByUuid(uuid).map(pE -> new Product(pE.getUuid(), pE.getName(), pE.getPrice()));
	}

	@Override
	public Optional<Product> findProductByName(String name) {
		return productsJpaRepository.findByName(name).map(pE -> new Product(pE.getUuid(), pE.getName(), pE.getPrice()));
	}

}
