package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.henrysgrocery.Item.BREAD;

@AllArgsConstructor
public class SoupOffer {
    private static final BigDecimal DISCOUNT_PER_QUANTITY = BREAD.getPrice().divide(BigDecimal.valueOf(2));
    private LocalDateTime offerStartDate;
    private LocalDateTime offerEndDate;

    public BigDecimal calculateDiscount(List<Item> shoppingList, LocalDateTime shoppingDate) {
        if ((shoppingDate.isBefore(offerStartDate))
                || (shoppingDate.isAfter(offerEndDate))) {
            return BigDecimal.ZERO;
        }

        long soupCount = (shoppingList.stream().filter(item -> item.equals(Item.SOUP)).count());
        BigDecimal discountQuantity = BigDecimal.valueOf(soupCount / 2);
        BigDecimal totalDiscountFromOffer = DISCOUNT_PER_QUANTITY.multiply(discountQuantity);

        long breadCount = (shoppingList.stream().filter(item -> item.equals(Item.BREAD)).count());
        BigDecimal breadCost = BREAD.getPrice().multiply(BigDecimal.valueOf(breadCount));

        return breadCost.min(totalDiscountFromOffer);
    }

}
