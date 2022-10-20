package com.smalaca.onlineshop.api.rest.cart;

import com.smalaca.onlineshop.query.cart.CartDto;
import com.smalaca.onlineshop.query.cart.CartQueryFacade;

public class CartRestController {
    public CartDto display() {
        return new CartQueryFacade().display();
    }

    public void addProduct() {
//        new CartCommandFacade().addProduct();
    }
}
