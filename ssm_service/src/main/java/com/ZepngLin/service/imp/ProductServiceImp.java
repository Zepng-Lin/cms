package com.ZepngLin.service.imp;

import com.ZepngLin.dao.ProductDao;
import com.ZepngLin.domain.Product;
import com.ZepngLin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao dao;
    @Override
    public List<Product> findAll() {
        System.out.println("service");
        return dao.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        dao.saveProduct(product);
    }
}
