package com.gestion.g04.services;


import com.gestion.g04.entities.Category;
import com.gestion.g04.entities.Product;
import com.gestion.g04.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<Product> findAllProductByPrix(Double prixProduct) {
        return productRepository.findAllProductByPrix(prixProduct);
    }

    @Override
    public List<Product> findAllProductByNomPrix(String designationProduct, Double prixProduct) {
        return productRepository.findAllProductByNomPrix(designationProduct,prixProduct);
    }

    @Override
    public List<Product> findAllProductByCategory(Category category) {
        return productRepository.findAllProductByCategory(category);
    }

    @Override
    public List<Product> findAllProductByNameSort() {
        return productRepository.findAllProductByNameSort();
    }

    @Override
    public void deleteProductById(Long IdProduct) {
          productRepository.deleteById(IdProduct);
    }

    @Override
    public void deleteAllProduct() {
        productRepository.deleteAll();

    }

    @Override
    public Page<Product> getAllProductByPage(int page, int size) {
        return productRepository.findAll(PageRequest.of(page,size));
    }


}
