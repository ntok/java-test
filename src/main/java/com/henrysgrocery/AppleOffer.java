package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.henrysgrocery.Item.APPLE;

@AllArgsConstructor
public class AppleOffer implements Offer{

    @Override
    public BigDecimal calculateDiscount(List<Item> shoppingList, LocalDateTime shoppingDate) {
        return APPLE.getPrice().multiply(BigDecimal.valueOf(0.1));
    }
}
