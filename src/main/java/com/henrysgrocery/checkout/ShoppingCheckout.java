package com.henrysgrocery.checkout;

import com.henrysgrocery.item.Item;
import com.henrysgrocery.offer.DiscountCalculator;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class ShoppingCheckout {

    private List<Item> items;
    private List<DiscountCalculator> discountCalculators;

    public BigDecimal checkout(LocalDateTime shoppingDate) {
        if (items == null) {
            throw new IllegalArgumentException("Shopping items is null");
        }
        BigDecimal basketPrice = items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDiscountForAllOffers = discountCalculators.stream()
                .map(calc -> calc.calculateDiscount(items, shoppingDate))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return basketPrice.subtract(totalDiscountForAllOffers);
    }
}
