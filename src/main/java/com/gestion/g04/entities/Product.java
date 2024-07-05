package com.gestion.g04.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String designationProduct;

    private Double prixProduct;


    private Date dateProduct;



    public Product() {
        super();
    }

    public Product(String designationProduct, Double prixProduct, Date dateProduct) {
        this.designationProduct = designationProduct;
        this.prixProduct = prixProduct;
        this.dateProduct = dateProduct;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getDesignationProduct() {
        return designationProduct;
    }

    public void setDesignationProduct(String designationProduct) {
        this.designationProduct = designationProduct;
    }

    public Double getPrixProduct() {
        return prixProduct;
    }

    public void setPrixProduct(Double prixProduct) {
        this.prixProduct = prixProduct;
    }


    public Date getDateProduct() {
        return dateProduct;
    }

    public void setDateProduct(Date dateProduct) {
        this.dateProduct = dateProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", designationProduct='" + designationProduct + '\'' +
                ", prixProduct=" + prixProduct +
                ", dateProduct=" + dateProduct +
                '}';
    }
}
