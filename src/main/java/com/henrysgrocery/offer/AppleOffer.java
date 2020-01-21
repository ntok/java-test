package com.henrysgrocery.offer;

import com.henrysgrocery.item.Item;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.henrysgrocery.item.Item.APPLE;

public class AppleOffer extends Offer implements DiscountCalculator {

    public AppleOffer(LocalDateTime offerStartDate, LocalDateTime offerEndDate) {
        super(offerStartDate, offerEndDate);
    }

    @Override
    public BigDecimal calculateDiscount(List<Item> shoppingList, LocalDateTime shoppingDate) {
        if (!isOfferValid(shoppingDate)) {
            return BigDecimal.ZERO;
        }

        long discountQuantity = getItemCount(shoppingList, APPLE);

        return BigDecimal.valueOf(0.01).multiply(BigDecimal.valueOf(discountQuantity));
    }


}
