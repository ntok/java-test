package com.henrysgrocery;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.henrysgrocery.Item.BREAD;
import static com.henrysgrocery.Item.SOUP;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SoupOfferTest {

    private SoupOffer soupOffer;

    @Before
    public void setUp() {
        soupOffer = new SoupOffer();
    }

    @Test
    public void whenBasketHasEnoughSoupsAndEnoughBreadForDiscount_thenCalculateBreadDiscount() {
        BigDecimal discount = soupOffer.calculateDiscount(asList(SOUP, SOUP, BREAD));

        assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.40));
    }

    @Test
    public void whenBasketHasManySoupsAndLessBreadCostThenDiscount_thenCalculateBreadDiscount() {
        BigDecimal discount = soupOffer.calculateDiscount(asList(SOUP, SOUP, SOUP, SOUP, SOUP, SOUP, BREAD));

        assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.80));
    }
}