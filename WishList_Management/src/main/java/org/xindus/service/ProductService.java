package org.xindus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.xindus.dao.ProductDao;
import org.xindus.dao.WishlistDao;
import org.xindus.entity.Product;
import org.xindus.entity.ResponseStructure;
import org.xindus.entity.Wishlist;
import org.xindus.exception.IdNotFoundException;


@Service
public class ProductService {
	@Autowired
	private ProductDao pDao;

	@Autowired
	private WishlistDao wDao;
	
	//POST
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product p, int wID){
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Wishlist> recWishlist = wDao.findWishlistById(wID);
		if(recWishlist.isPresent()) {
			
			Wishlist w = recWishlist.get();
			w.getProducts().add(p);
			p.setWishlist(w);
			wDao.updateWishlist(w);
			pDao.saveProduct(p);	
			
			structure.setData(p);
			structure.setMessage("Product Account Created Succesfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	//PUT 
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product p, int wID){
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Wishlist> recWishlist = wDao.findWishlistById(wID);
		if(recWishlist.isPresent()) {
			Wishlist w = recWishlist.get();
			p.setWishlist(w);
			wDao.updateWishlist(w);
			pDao.updateProduct(p);
			
			structure.setData(p);
			structure.setMessage("Product Details Updated Succesfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	//GET
	public ResponseEntity<ResponseStructure<Product>> findById(int pID){
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> recProduct = pDao.findProductById(pID);
		if(recProduct.isPresent()) {
			structure.setMessage("Product Found Successfully");
			structure.setData(recProduct.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	//DELETE - /delete/{Wishlist_id}
	public ResponseEntity<ResponseStructure<String>> deleteProduct(int pID){
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> recProduct = pDao.findProductById(pID);
		if(recProduct.isPresent()) {
			pDao.deleteProduct(pID);
			
			structure.setMessage("Task Executed");
			structure.setData("Product Deleted Succesfully");		
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	} 
}
