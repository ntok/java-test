package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class ShoppingCalculator {

    private List<String> items;
    private SoupOffer soupOffer;

    public BigDecimal calculate() {
        if(items==null){
            throw new IllegalArgumentException("Shopping items is null");
        }
        BigDecimal basketPrice = items.stream()
                .map(s -> Item.valueOf(s.toUpperCase()).getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return basketPrice.subtract(soupOffer.calculateDiscount(items));
    }
}
