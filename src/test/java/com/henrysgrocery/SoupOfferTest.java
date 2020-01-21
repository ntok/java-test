package com.henrysgrocery;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SoupOfferTest {

    private List<String> shoppingItems = new ArrayList<>();

    @Test
    public void whenBasketHasEnoughSoupsAndEnoughBreadForDiscount_thenCalculateBreadDiscount() {
        shoppingItems.add("SOUP");
        shoppingItems.add("SOUP");
        shoppingItems.add("BREAD");
        BigDecimal discount = new SoupOffer().calculateDiscount(shoppingItems);
        assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.40));
    }
}