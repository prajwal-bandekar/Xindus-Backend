package org.xindus.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xindus.entity.Product;
import org.xindus.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository pRepo;
	
	public Product saveProduct(Product p) {
		return pRepo.save(p);
	}
	
	public Product updateProduct(Product p) {
		return pRepo.save(p);
	}
	
	public Optional<Product> findProductById(int pID) {
		return pRepo.findById(pID);
	}
	
	public void deleteProduct(int pID) {
		pRepo.deleteById(pID);
	}
}
