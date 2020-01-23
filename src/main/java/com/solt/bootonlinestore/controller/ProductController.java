package com.solt.bootonlinestore.controller;

import com.solt.bootonlinestore.domain.Products;
import com.solt.bootonlinestore.service.CategoryService;
import com.solt.bootonlinestore.service.ProductsService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductsService productsService;
    private final CategoryService categoryService;

    public ProductController(ProductsService productsService,
                             CategoryService categoryService) {
        this.productsService = productsService;
        this.categoryService= categoryService;
    }

    @GetMapping
    public String create(Model model){
        model.addAttribute("product",new Products());
        model.addAttribute("categories",categoryService.findAll());
        return "admin/productForm";
    }

    @PostMapping()
    public String process(Products products, BindingResult result){
        if(result.hasErrors()){
            return "admin/productForm";
        }
        this.productsService.create(products);

        return "redirect:/product/all";
    }

    @GetMapping("/all")
    public String showAllProducts(Model model){
        model.addAttribute("products",productsService.findAll());
        return "admin/products";
    }

    @GetMapping("/item")
    public String showDetailsProduct(Model model,@RequestParam  long id){
        model.addAttribute("product",productsService.findProductsById(id));
        return "admin/product";
    }

    @GetMapping("/category/{cid}")
    public String showAllProductsByCategory(Model model, @PathVariable long cid){
        model.addAttribute("products"
                ,this.productsService.findAllByCategoryId(cid));
        return "user/products";

    }
    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/api/category/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> getAllProductsByCId(@PathVariable long id){
        return this.productsService.findAllByCategoryId(id);
    }

    @GetMapping("/{id}")
    public String showProductDetails(Model model, @PathVariable long id,
                                     HttpServletRequest request){
        model.addAttribute("product",productsService.findProductsById(id));
        HttpSession session=request.getSession(false);
        if(session!=null){
            model.addAttribute("cartSize",session.getAttribute("cartItem"));
        }


        return "user/product";
    }





}
