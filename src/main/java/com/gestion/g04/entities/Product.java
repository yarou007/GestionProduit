package com.gestion.g04.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;



    @NotNull
    @Size(min = 3,max = 20)
    private String designationProduct;

    @Min(10)
    @Max(10000)
    private Double prixProduct;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateProduct;


    @ManyToOne
    private Category category;

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
