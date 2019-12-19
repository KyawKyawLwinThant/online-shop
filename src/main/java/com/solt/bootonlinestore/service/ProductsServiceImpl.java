package com.solt.bootonlinestore.service;


import com.solt.bootonlinestore.domain.Products;
import com.solt.bootonlinestore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductRepository productRepository;

    public ProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Products create(Products products) {
        return this.productRepository.save(products);
    }

    @Override
    public Products findProductsById(long id) {
        return this.productRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException(id + " Not Found!"));
    }

    @Override
    public List<Products> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Products> findAllByCategoryId(long cid) {
        return this.productRepository.findByProductsCategory(cid);
    }

}
