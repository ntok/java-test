package com.henrysgrocery;

import java.math.BigDecimal;
import java.util.List;

import static com.henrysgrocery.Item.BREAD;

public class SoupOffer {
    public BigDecimal calculateDiscount(List<Item> shoppingList) {
        long soupCount = (shoppingList.stream().filter(item -> item.equals(Item.SOUP)).count());
        BigDecimal discountPerQuantity = BREAD.getPrice().divide(BigDecimal.valueOf(2));
        BigDecimal discountQuantity = BigDecimal.valueOf(soupCount / 2);

        return discountPerQuantity.multiply(discountQuantity);
    }

}
