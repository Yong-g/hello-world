package com.briup.serivce.product;

import com.briup.bean.user.Product;
import com.briup.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSerivceImpl implements ProductSerivce {

    @Autowired
    private ProductDao productDao;


    @Override
    public Product create(Product product) {
       return productDao.save(product);

    }

    @Override
    public Product findById(String productId) {
       return productDao.findById(productId).isPresent() ? productDao.findById(productId).get() : null ;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findOne(Product product) {
        return productDao.findOne(Example.of(product)).isPresent() ? productDao.findOne(Example.of(product)).get() : null;
    }

    @Override
    public void delete(String productId) {
        productDao.deleteById(productId);
    }

    @Override
    public boolean checkProduct(Product product) {
        List<Object> products = productDao.checkProduct(product.getProductCode(), product.getProductName());
        return products.size() > 0 ? false : true;
    }

}
