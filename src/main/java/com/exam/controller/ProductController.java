package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Product;
import com.exam.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;
	

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		
		Product pro = service.createProduct(product);
		
		return pro ;
		
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable ("id") Integer id) {
		return service.getProductById(id);
	}
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable("id") int id) {
		return service.updateProduct(product,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		service.deleteProductById(id);
	}
	
	 @GetMapping()
	    public Page<Product> getProductsByPage(@RequestParam(value = "page") int page) {
	        Pageable pageable = PageRequest.ofSize(page);
	        return service.getProductsByPage(pageable);
	    }
}
