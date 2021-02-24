package com.briup.bean.user;

import javax.persistence.*;

@Entity
@Table(name = "t_product")
public class Product {

    @Column(name = "productName",unique = true,nullable = false)
    private String  productName;
    @Id
    @Column(name = "productCode")
    private String productCode;
    @Column(name = "description")
    private String description;
    @Column(name = "price" , nullable = false)
    private String price;
    @Column(name = "ex")
    private String ex;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", ex='" + ex + '\'' +
                '}';
    }
}
