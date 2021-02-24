package com.briup.controller;

import com.briup.bean.user.Product;
import com.briup.common.respose.SimpleRespose;
import com.briup.dao.ProductDao;
import com.briup.serivce.product.ProductSerivce;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product/")
public class ProductController {

    @Autowired
    private ProductSerivce productSerivce;

    @GetMapping("getProductByCode")
    @ResponseBody
    private Object getProductById(@RequestParam String productCode) {
        Product byId = productSerivce.findById(productCode);
        return new SimpleRespose<>(byId, "", "0");
    }

    @PostMapping("findAll")
    @ResponseBody
    private Object findAll(){
        return productSerivce.findAll();
    }

    @PostMapping("create")
    @ResponseBody
    private Object create(@RequestBody Product product){
        boolean checkProduct = productSerivce.checkProduct(product);
        if (!checkProduct){
            return new SimpleRespose(null,"产品已存在","1");
        }
        return new SimpleRespose(productSerivce.create(product),"","0");
    }

    @PostMapping("delete")
    @ResponseBody
    private Object delete(@RequestParam String productCode){
        productSerivce.delete(productCode);
        return new SimpleRespose<>(null,null,"0");
    }

}
