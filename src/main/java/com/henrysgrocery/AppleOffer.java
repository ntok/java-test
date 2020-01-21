package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class AppleOffer implements Offer{

    @Override
    public BigDecimal calculateDiscount(List<Item> shoppingList, LocalDateTime shoppingDate) {
        return null;
    }
}
