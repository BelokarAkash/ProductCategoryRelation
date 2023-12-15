package com.exam.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exam.entity.Product;
import com.exam.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product createProduct(Product product) {
		return repo.save(product);
	}
	public Product getProductById(Integer id) {
		return repo.findById(id).get();
	}
	
	public Product updateProduct(Product product,Integer id) {
		Optional<Product> p1 = repo.findById(id);
		if (Objects.isNull(p1)){
			return null;	
		}
		
		
		return repo.save(product);
	}
	public void deleteProductById(Integer id) {
		
		 repo.deleteById(id);
	}
	public Page<Product> getProductsByPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
	
	

}
