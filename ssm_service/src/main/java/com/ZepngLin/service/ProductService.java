package com.ZepngLin.service;

import com.ZepngLin.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public void saveProduct(Product product);
}
