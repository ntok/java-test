package com.henrysgrocery;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.henrysgrocery.Item.BREAD;
import static com.henrysgrocery.Item.SOUP;

public class SoupOffer extends Offer implements DiscountCalculator {
    private static final BigDecimal DISCOUNT_PER_QUANTITY = BREAD.getPrice().divide(BigDecimal.valueOf(2));

    public SoupOffer(LocalDateTime offerStartDate, LocalDateTime offerEndDate) {
        super(offerStartDate, offerEndDate);
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> shoppingList, LocalDateTime shoppingDate) {
        if (!isOfferValid(shoppingDate)) {
            return BigDecimal.ZERO;
        }

        BigDecimal discountQuantity = BigDecimal.valueOf((getItemCount(shoppingList, SOUP)) / 2);
        BigDecimal totalDiscountFromOffer = DISCOUNT_PER_QUANTITY.multiply(discountQuantity);

        BigDecimal breadCost = BREAD.getPrice().multiply(BigDecimal.valueOf((getItemCount(shoppingList, BREAD))));

        return breadCost.min(totalDiscountFromOffer);
    }

}
