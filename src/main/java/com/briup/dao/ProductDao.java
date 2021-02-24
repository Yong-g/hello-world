package com.briup.dao;

import com.briup.bean.user.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface ProductDao extends JpaRepository<Product,String> {

    @Query(value = "select * from t_product p where p.product_code =  ?1 or p.product_name = ?2" ,nativeQuery=true)
    List<Object> checkProduct(String productCode, String productName);
}
