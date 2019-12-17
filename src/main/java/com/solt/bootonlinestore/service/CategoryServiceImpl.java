package com.solt.bootonlinestore.service;

import com.solt.bootonlinestore.domain.Category;
import com.solt.bootonlinestore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(id + "Not Found!"));
    }
}
