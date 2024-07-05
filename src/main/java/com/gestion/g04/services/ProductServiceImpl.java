package com.gestion.g04.services;


import com.gestion.g04.entities.Product;
import com.gestion.g04.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {



    @Autowired
     ProductRepository productRepository;



    @Override
    public Product saveProduct(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long IdProduct) {
           return productRepository.findById(IdProduct).get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long IdProduct) {
          productRepository.deleteById(IdProduct);
    }

    @Override
    public void deleteAllProduct() {
        productRepository.deleteAll();

    }
}
