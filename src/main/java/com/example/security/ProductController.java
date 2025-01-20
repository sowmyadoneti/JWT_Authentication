package com.example.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PreAuthorize("hasAnyAuthority('read_product','admin')")
	@GetMapping
    public List<Productentity> getAllActiveProducts() {
        return productService.getAllActiveProducts();
    }
	
	@PreAuthorize("hasAnyAuthority('read_product','admin')")
	@GetMapping("/all")
    public List<Productentity> getAllProducts() {
        return productService.getAllProducts();
    }
	
	@PreAuthorize("hasAnyAuthority('manage_product','admin')")
    @PostMapping
    public Productentity createProduct(@RequestBody Productentity product) {
        return productService.createProduct(product);
    }
	
	@PreAuthorize("hasAnyAuthority('manage_product','admin')")
    @PutMapping("/{id}")
    public Productentity updateProduct(@PathVariable Integer id, @RequestBody Productentity updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }
	
	@PreAuthorize("hasAnyAuthority('manage_product','admin')")
    @DeleteMapping("/{id}")
    public void softDeleteProduct(@PathVariable Integer id) {
        productService.softDeleteProduct(id);
    }
	
	@PreAuthorize("hasAnyAuthority('admin')")
    @DeleteMapping("/hard/{id}")
    public void hardDeleteProduct(@PathVariable Integer id) {
        productService.hardDeleteProduct(id);
    }
}
	
