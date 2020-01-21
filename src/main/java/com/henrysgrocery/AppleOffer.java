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
        long discountQuantity =  (shoppingList.stream().filter(item -> item.equals(APPLE)).count());

        return BigDecimal.valueOf(0.01).multiply(BigDecimal.valueOf(discountQuantity));
    }

}
