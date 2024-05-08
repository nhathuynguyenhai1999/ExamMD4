package com.codegym.exammd4.controller;

import com.codegym.exammd4.model.Product;
import com.codegym.exammd4.repository.IProductRepository;
import com.codegym.exammd4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Iterable<Product>> listProducts(){
        return new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(product.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct1(@PathVariable Long id, @RequestBody Product product){
        Product product1 = new Product();
        product1.setId(id);
        product1.setProducer(product1.getModel());
        product1.setModel(product.getModel());
        product1.setPrice(product1.getPrice());
        return new ResponseEntity<>(productService.save(product1), HttpStatus.OK);
    }
}
