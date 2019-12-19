package com.solt.bootonlinestore.repository;

import com.solt.bootonlinestore.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

    List<Products> findProductsByCategory_Id(long cid);

    @Query("select p from Products  p where p.category.id=:cid")
    List<Products> findByProductsCategory(@Param("cid") long cid);

}
