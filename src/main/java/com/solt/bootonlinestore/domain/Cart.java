package com.solt.bootonlinestore.domain;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Cart {
    private Set<Products>
         cartItems=new HashSet<>();

    public void addToCart(Products products){
        cartItems.add(products);
    }

    public  void clearCart(){
        cartItems.clear();
    }

    public int cartSize(){
        if(cartItems.isEmpty()){
            return 0;
        }
        return cartItems.size();
    }

    public Set<Products> getCartItems(){
        return this.cartItems;
    }

}
