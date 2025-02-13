package com.codegym.exammd4.service;

import com.codegym.exammd4.model.Product;
import com.codegym.exammd4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Iterable<Product> findAll(){
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findById1(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Product save(Product product){
        return iProductRepository.save(product);
    }
    @Override
    public void remove(Long id){
        iProductRepository.deleteById(id);
    }
}
