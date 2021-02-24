package com.briup.serivce.product;

import com.briup.bean.user.Product;

import java.util.List;
public interface ProductSerivce {

    Product create(Product product);

    Product findById(String productId);

    List<Product> findAll();

    Product findOne(Product product);

    void delete(String productId);

    boolean checkProduct(Product product);
}
