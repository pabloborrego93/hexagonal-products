package com.pborrego.hexagonalarchitecture.products.infastructure.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pborrego.hexagonalarchitecture.products.application.ports.input.ProductCreationInputPort;
import com.pborrego.hexagonalarchitecture.products.application.ports.output.ProductPersistenceOutputPort;
import com.pborrego.hexagonalarchitecture.products.application.usecases.ProductCreationUseCase;
import com.pborrego.hexagonalarchitecture.products.infastructure.adapters.output.jpa.ProductsJpaRepository;
import com.pborrego.hexagonalarchitecture.products.infastructure.adapters.output.jpa.ProductsPersistenceJpaOutputAdapter;

@Configuration
public class BeansFactory {

	@Bean
	ProductPersistenceOutputPort productsPersistenceJpaOutputAdapter(ProductsJpaRepository productsJpaRepository) {
		return new ProductsPersistenceJpaOutputAdapter(productsJpaRepository);
	}
	
	@Bean
	ProductCreationInputPort productCreationUseCase(ProductPersistenceOutputPort productPersistenceOutputPort) {
		return new ProductCreationUseCase(productPersistenceOutputPort);
	}
	
}
