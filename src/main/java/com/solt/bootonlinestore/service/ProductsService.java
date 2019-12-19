package com.solt.bootonlinestore.service;

import com.solt.bootonlinestore.domain.Products;

import java.util.List;

public interface ProductsService {
    Products create(Products products);
    Products findProductsById(long id);
    List<Products> findAll();
    List<Products> findAllByCategoryId(long cid);
}
