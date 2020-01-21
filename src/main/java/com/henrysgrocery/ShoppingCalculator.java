package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class ShoppingCalculator {

    private List<Item> items;
    private List<Offer> offers;

    public BigDecimal calculate(LocalDateTime shoppingDate) {
        if (items == null) {
            throw new IllegalArgumentException("Shopping items is null");
        }
        BigDecimal basketPrice = items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDiscountForAllOffers = offers.stream()
                .map(calc -> calc.calculateDiscount(items, shoppingDate))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return basketPrice.subtract(totalDiscountForAllOffers);
    }
}
