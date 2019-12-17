package com.solt.bootonlinestore.repository;

import com.solt.bootonlinestore.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {
}
