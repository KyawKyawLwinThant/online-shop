package com.solt.bootonlinestore.service;

import com.solt.bootonlinestore.domain.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    List<Category> findAll();

    Category findCategoryById(long id);
}
