package com.mycompany.pos.service;

import com.mycompany.pos.entity.Product;
import com.mycompany.pos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {return productRepository.findAll();}

    public void delete(Product product) {productRepository.delete(product);}

    public void save(Product product) {productRepository.save(product);}
}
