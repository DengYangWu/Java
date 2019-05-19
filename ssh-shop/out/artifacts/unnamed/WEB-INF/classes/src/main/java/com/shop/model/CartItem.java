package com.shop.model;

import lombok.Data;

@Data
public class CartItem {
    private Product product; //shopping items messages
    private Float price = 1.0f;  //count price
    private int count;   //buy something commodity is count
    @SuppressWarnings("unused")
    private float subtotal;  //buy something commodity is subtotal

}
