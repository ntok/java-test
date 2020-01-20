package com.henrysgrocery;

import java.math.BigDecimal;
import java.util.List;

import static com.henrysgrocery.Item.BREAD;
import static java.util.stream.Collectors.counting;

public class SoupOffer {
    public BigDecimal calculateDiscount(List<String> shoppingList) {
        int soupCount = shoppingList.stream().filter(item -> item.equals("SOUP")).collect(counting()).intValue();
        BigDecimal discountPerQuantity=BREAD.getPrice().divide(BigDecimal.valueOf(2));
        BigDecimal discountQuantity = BigDecimal.valueOf(soupCount / 2);

        return discountPerQuantity.multiply(discountQuantity);
    }

}
