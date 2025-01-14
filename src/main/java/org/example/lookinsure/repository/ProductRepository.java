package org.example.lookinsure.repository;

import org.example.lookinsure.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
