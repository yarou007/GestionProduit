package com.gestion.g04.services;


import com.gestion.g04.entities.Category;
import com.gestion.g04.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService  {

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    Product getProduct(Long IdProduct);

    List<Product> getAllProduct();

    List<Product> findAllProductByPrix (Double prixProduct) ;

    List<Product> findAllProductByNomPrix (@Param("designationProduct") String designationProduct, @Param("prixProduct") Double prixProduct) ;

    List<Product> findAllProductByCategory (Category category) ;

    List<Product> findAllProductByNameSort() ;

    //
    void deleteProductById(Long IdProduct);

    void deleteAllProduct();


    Page<Product> getAllProductByPage(int page, int size);
}
