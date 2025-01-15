package org.example.lookinsure.repository;

import org.example.lookinsure.domain.ProductConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductConfigRepository extends JpaRepository<ProductConfig, Long> {

    List<ProductConfig> findByVisibleTrue();

}
