package com.henrysgrocery;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.henrysgrocery.Item.BREAD;
import static com.henrysgrocery.Item.SOUP;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SoupOfferTest {

    @Test
    public void whenBasketHasEnoughSoupsAndEnoughBreadForDiscount_thenCalculateBreadDiscount() {
        BigDecimal discount = new SoupOffer().calculateDiscount(asList(SOUP, SOUP, BREAD));

        assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.40));
    }
}