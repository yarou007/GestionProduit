package com.gestion.g04.repositories;

import com.gestion.g04.entities.Category;
import com.gestion.g04.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("select p from Product p where p.prixProduct>?1") // 1 pour le premier parametre fil methode
    List<Product> findAllProductByPrix (Double prixProduct) ;


    @Query("select p from Product p where p.designationProduct like %:designationProduct and p.prixProduct>:prixProduct ") // : heki 3ibara aal binding param behs tkaser el sql injection
    List<Product> findAllProductByNomPrix (@Param("designationProduct") String designationProduct, @Param("prixProduct") Double prixProduct) ;


    @Query("select p from Product p where p.category=?1")
    List<Product> findAllProductByCategory (Category category) ;


    @Query("select p from Product p order by p.designationProduct")
    List<Product> findAllProductByNameSort() ;

}
