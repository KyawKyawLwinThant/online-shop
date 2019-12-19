package com.solt.bootonlinestore.controller;

import com.solt.bootonlinestore.domain.Cart;
import com.solt.bootonlinestore.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final Cart cart;
    private final ProductsService productsService;

    public CartController(Cart cart,ProductsService productsService) {
        this.cart = cart;
        this.productsService=productsService;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable long id, Model model){
        cart.addToCart(productsService.findProductsById(id));
        model.addAttribute("cartSize",cart.cartSize());
        log.info("cart size:"+ cart.cartSize());

        return "redirect:/product/"+id;
    }

    private  final Logger log=LoggerFactory.getLogger(this.getClass());
}
