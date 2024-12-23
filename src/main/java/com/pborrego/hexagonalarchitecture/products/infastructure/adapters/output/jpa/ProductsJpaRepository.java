package com.pborrego.hexagonalarchitecture.products.infastructure.adapters.output.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsJpaRepository extends JpaRepository<ProductDatabaseEntity, Long> {
	
    Optional<ProductDatabaseEntity> findByName(String name);
    Optional<ProductDatabaseEntity> findByUuid(UUID uuid);
}