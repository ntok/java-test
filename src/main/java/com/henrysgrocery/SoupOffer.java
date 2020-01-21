package com.henrysgrocery;

import java.math.BigDecimal;
import java.util.List;

import static com.henrysgrocery.Item.BREAD;

public class SoupOffer {
    private static final BigDecimal DISCOUNT_PER_QUANTITY = BREAD.getPrice().divide(BigDecimal.valueOf(2));

    public BigDecimal calculateDiscount(List<Item> shoppingList) {

        long soupCount = (shoppingList.stream().filter(item -> item.equals(Item.SOUP)).count());
        BigDecimal discountQuantity = BigDecimal.valueOf(soupCount / 2);
        BigDecimal totalDiscountFromOffer = DISCOUNT_PER_QUANTITY.multiply(discountQuantity);

        long breadCount = (shoppingList.stream().filter(item -> item.equals(Item.BREAD)).count());
        BigDecimal breadCost = BREAD.getPrice().multiply(BigDecimal.valueOf(breadCount));

        return breadCost.min(totalDiscountFromOffer);
    }

}
