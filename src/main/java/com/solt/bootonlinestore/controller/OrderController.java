package com.solt.bootonlinestore.controller;

import com.solt.bootonlinestore.domain.Cart;
import com.solt.bootonlinestore.domain.User;
import com.solt.bootonlinestore.repository.UserRepository;
import com.solt.bootonlinestore.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;
    private final Cart cart;

    public OrderController(UserDetailsServiceImpl userDetailsService,
                           Cart cart,
                           UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.cart=cart;
        this.userRepository=userRepository;
    }

    @GetMapping("/order/signup")
    public String userSingUp(Model model){
        model.addAttribute("user",new User());
        return "auth/signup";
    }
    @PostMapping("/order/signup")
    public String userProcess(User user){

        User user1=userDetailsService.signup(user);
        if(user1!=null) {
            this.userId = user1.getId();
        }
        return "redirect:/user/checkout";
    }
    @GetMapping("/user/checkout")
    public String checkout(Model model){

        model.addAttribute("user",userRepository.getOne(userId));
        model.addAttribute("products",cart.getCartItems());

        return "user/checkout";
    }


    private long userId;


}
