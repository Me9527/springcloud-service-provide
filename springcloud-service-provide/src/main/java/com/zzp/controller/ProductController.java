package com.zzp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zzp.pojo.Product;
import com.zzp.service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProdut/{id}")
    public Product getUser(@PathVariable("id")  Long productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/getAllProduct")
    public List<Product> getUser(){
        return productService.getAllProduct();
    }
    
    @DeleteMapping("/deleteProductById/{id}")
    public void deleteProductById(@PathVariable("id")  Long id){
    	productService.deleteProductById(id);
    }

    @PostMapping("/addProduct")
    public void addProduct(Product product){
    	
    	productService.addProduct(product);
    }
    
    @GetMapping("/addProduct2")
    public void addProduct2(@RequestParam("name") String name, @RequestParam("descrpit") String descrpit, @RequestParam("price") BigDecimal price){
    	Product product = new Product(name, descrpit, price) ;
    	productService.addProduct(product);
    }
}
