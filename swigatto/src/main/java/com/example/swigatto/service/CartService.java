package com.example.swigatto.service;

import com.example.swigatto.dto.request.FoodRequest;
import com.example.swigatto.dto.response.CartStatusResponse;
import com.example.swigatto.dto.response.FoodResponse;
import com.example.swigatto.exception.CustomerNotFoundException;
import com.example.swigatto.exception.MenuItemNotFoundException;
import com.example.swigatto.model.Cart;
import com.example.swigatto.model.Customer;
import com.example.swigatto.model.FoodItem;
import com.example.swigatto.model.MenuItem;
import com.example.swigatto.repository.CartRepository;
import com.example.swigatto.repository.CustomerRepository;
import com.example.swigatto.repository.FoodRepository;
import com.example.swigatto.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    final CustomerRepository customerRepository;
    final MenuRepository menuRepository;
    final FoodRepository foodRepository;
    final CartRepository cartRepository;

    @Autowired
    public CartService(CustomerRepository customerRepository,
                       MenuRepository menuRepository,
                       FoodRepository foodRepository,
                       CartRepository cartRepository){
        this.customerRepository = customerRepository;
        this.menuRepository = menuRepository;
        this.foodRepository = foodRepository;
        this.cartRepository = cartRepository;
    }
    public CartStatusResponse addFoodItemToCart(FoodRequest foodRequest) {

        Customer customer = customerRepository.findByMobileNo(foodRequest.getCustomerMobile());
        if(customer == null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        Optional<MenuItem> menuItemOptional = menuRepository.findById(foodRequest.getMenuItemId());
        if(menuItemOptional.isEmpty()){
            throw new MenuItemNotFoundException("Item not available in the Restaurant !!!");
        }

        MenuItem menuItem = menuItemOptional.get();
        if(!menuItem.getRestaurant().isOpened() || !menuItem.isAvailable()){
           throw new MenuItemNotFoundException("Given dish is out of Stock for now!!!");
        }

        // ready to add item to cart
        FoodItem foodItem = FoodItem.builder()
                .menuItem(menuItem)
                .requiredQuantity(foodRequest.getRequiredQuantity())
                .totalCost(foodRequest.getRequiredQuantity()*menuItem.getPrice())
                .build();

        Cart cart = customer.getCart();
        FoodItem savedFoodItem = foodRepository.save(foodItem);

        double cartTotal = 0;
        cart.getFoodItems().add(savedFoodItem);
        for(FoodItem food: cart.getFoodItems()){
            cartTotal += food.getRequiredQuantity()* food.getMenuItem().getPrice();
        }

        savedFoodItem.setCart(cart);
        cart.setCartTotal(cartTotal);
        menuItem.getFoodItems().add(savedFoodItem);

        // save
        Cart savedCart = cartRepository.save(cart);
        MenuItem savedMenuItem = menuRepository.save(menuItem);

        // prepare
        List<FoodResponse> foodResponseList = new ArrayList<>();
        for(FoodItem food: cart.getFoodItems()){
            FoodResponse foodResponse = FoodResponse.builder()
                    .dishName(food.getMenuItem().getDishName())
                    .price(food.getMenuItem().getPrice())
                    .category(food.getMenuItem().getCategory())
                    .veg(food.getMenuItem().isVeg())
                    .quantityAdded(food.getRequiredQuantity())
                    .build();

            foodResponseList.add(foodResponse);
        }

        return CartStatusResponse.builder()
                .customerName(savedCart.getCustomer().getName())
                .customerMobile(savedCart.getCustomer().getMobileNo())
                .customerAddress(savedCart.getCustomer().getAddress())
                .foodList(foodResponseList)
                .restaurantName(savedMenuItem.getRestaurant().getName())
                .cartTotal(cartTotal)
                .build();
    }
}