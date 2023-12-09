package com.example.swigatto.transformer;

import com.example.swigatto.dto.request.MenuRequest;
import com.example.swigatto.dto.response.MenuResponse;
import com.example.swigatto.model.MenuItem;

public class MenuItemTransformer {

    public static MenuItem MenuRequestToMenuItem(MenuRequest menuRequest){
        return MenuItem.builder()
                .dishName(menuRequest.getDishName())
                .price(menuRequest.getPrice())
                .category(menuRequest.getCategory())
                .veg(menuRequest.isVeg())
                .available(menuRequest.isAvailable())
                .build();
    }

    public static MenuResponse MenuItemToMenuResponse(MenuItem menuItem){

        return MenuResponse.builder()
                .dishName(menuItem.getDishName())
                .price(menuItem.getPrice())
                .veg(menuItem.isVeg())
                .category(menuItem.getCategory())
                .build();
    }
}
