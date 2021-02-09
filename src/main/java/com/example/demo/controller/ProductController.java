package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@RestController
//@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository repo;
	@PostMapping("/addOne")
	public Product addProduct(@RequestBody Product product) {
		return repo.save(product);
	}
    @PostMapping("/addList")
    public List<Product> addProductList(@RequestBody List<Product> products){
    	return repo.saveAll(products);
    }
    @GetMapping("/getAll")
    public List<Product> getAllProduct(){
    	return repo.findAll();
    }
    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
    	return repo.findById(id);
    }
}
