package com.gestion.g04.services;


import com.gestion.g04.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService  {

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    Product getProduct(Long IdProduct);

    List<Product> getAllProduct();

    //
    void deleteProductById(Long IdProduct);

    void deleteAllProduct();


}
