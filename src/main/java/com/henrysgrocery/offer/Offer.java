package com.henrysgrocery.offer;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
abstract class Offer {
    protected LocalDateTime offerStartDate;
    protected LocalDateTime offerEndDate;

    boolean isOfferValid(LocalDateTime shoppingDate) {
        return !shoppingDate.isBefore(offerStartDate)
                && !shoppingDate.isAfter(offerEndDate);
    }

}
