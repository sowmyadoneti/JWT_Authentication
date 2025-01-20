package com.example.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	

	public List<Productentity> getAllActiveProducts() {
		return productRepo.findByIsdeletedFalse();
	}
	
	public List<Productentity> getAllProducts() {
        return productRepo.findAll();
    }

	public Productentity createProduct(Productentity product) {
		return productRepo.save(product);
	}

	public Productentity updateProduct(Integer id, Productentity updatedProduct) {
		Productentity p= productRepo.findById(id).orElseThrow(()->new RuntimeException("Product not found"+id));
		p.setName(updatedProduct.getName());
		p.setDiscription(updatedProduct.getDiscription());
		p.setCost(updatedProduct.getCost());
		return productRepo.save(p);
	}

	public void softDeleteProduct(Integer id) {
		Productentity product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setIsdeleted(true);
        productRepo.save(product);
		
	}

	public void hardDeleteProduct(Integer id) {
		
		productRepo.deleteById(id);
	}

	

}
