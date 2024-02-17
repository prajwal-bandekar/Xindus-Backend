package org.xindus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xindus.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
