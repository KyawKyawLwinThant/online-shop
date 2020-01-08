package com.solt.bootonlinestore.controller;

import com.solt.bootonlinestore.domain.Category;
import com.solt.bootonlinestore.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "admin/categoryForm";
    }

    @PostMapping
    public String process(Category category,BindingResult result){
        if(result.hasErrors()){
            return "admin/categoryForm";
        }
        categoryService.create(category);

        return "redirect:/category/all";
    }
    @GetMapping("/all")
    public String showAllCategories(Model model){

        model.addAttribute("categories",categoryService.findAll());

        return "admin/categories";
    }
    @GetMapping("/{id}")
    public String goToDetails(Model model,@PathVariable long id){
        model.addAttribute("category",categoryService.findCategoryById(id));
        return "admin/category";
    }



}
