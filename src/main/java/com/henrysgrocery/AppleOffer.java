package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.henrysgrocery.Item.APPLE;

@AllArgsConstructor
public class AppleOffer implements Offer {

    private LocalDateTime offerStartDate;
    private LocalDateTime offerEndDate;

    @Override
    public BigDecimal calculateDiscount(List<Item> shoppingList, LocalDateTime shoppingDate) {
        long discountQuantity = getItemCount(shoppingList, APPLE);

        return BigDecimal.valueOf(0.01).multiply(BigDecimal.valueOf(discountQuantity));
    }

}
