package com.example.swigatto.transformer;

import com.example.swigatto.dto.response.CartResponse;
import com.example.swigatto.model.Cart;

import java.util.ArrayList;

public class CartTransformer {

    public static CartResponse CartToCartResponse(Cart cart){
        return CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();
    }


}
