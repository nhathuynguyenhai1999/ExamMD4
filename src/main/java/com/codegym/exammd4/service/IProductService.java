package com.codegym.exammd4.service;

import com.codegym.exammd4.model.Product;

import java.util.Optional;

public interface IProductService{
    Iterable<Product> findAll();
    Optional<Product> findById(int id);

    Optional<Product> findById1(Long id);

    Product save(Product product);
    void remove(Long id);

    Optional<Product> findById(Long id);
}
