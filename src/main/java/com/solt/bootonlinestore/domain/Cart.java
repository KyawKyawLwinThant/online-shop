package com.solt.bootonlinestore.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Cart {
    private Set<Products>
         cartItems=new HashSet<>();

    private List<Integer> quantities=
            new ArrayList<>();

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

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public Set<Products> getCartItems(){
        return this.cartItems;
    }

}
