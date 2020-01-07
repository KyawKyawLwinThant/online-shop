package com.solt.bootonlinestore.controller;

import com.solt.bootonlinestore.domain.Cart;
import com.solt.bootonlinestore.domain.Products;
import com.solt.bootonlinestore.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

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
    public String addToCart(@PathVariable long id, HttpServletRequest request){
        cart.addToCart(productsService.findProductsById(id));
        HttpSession session=request.getSession();
        session.setAttribute("cartItem",cart.cartSize());
        log.info("cart size:"+ cart.cartSize());

        return "redirect:/product/"+id;
    }

    @GetMapping("/cartview")
    public String showViewCart(Model model){
        model.addAttribute("products",cart.getCartItems());
        return "user/cartView";
    }
    @GetMapping("/clear")
    public String clearCart(){
        cart.clearCart();
        return "redirect:/cart/cartview";
    }






    private  final Logger log=LoggerFactory.getLogger(this.getClass());
}
