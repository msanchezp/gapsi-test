package com.gapsi.apiproducts.repository;

import com.gapsi.apiproducts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
