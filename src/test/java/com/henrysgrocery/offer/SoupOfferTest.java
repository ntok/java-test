package com.henrysgrocery.offer;

import com.henrysgrocery.offer.SoupOffer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.henrysgrocery.item.Item.BREAD;
import static com.henrysgrocery.item.Item.SOUP;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SoupOfferTest {

    private SoupOffer soupOffer;

    @Before
    public void setUp() {
        soupOffer = new SoupOffer(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(7));
    }

    @Test
    public void whenBasketHasEnoughSoupsAndEnoughBreadForDiscount_thenCalculateBreadDiscount() {
        BigDecimal discount = soupOffer.calculateDiscount(asList(SOUP, SOUP, BREAD), LocalDateTime.now());

        assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.40));
    }

    @Test
    public void whenBasketHasManySoupsAndLessBreadCostThenDiscount_thenCalculateBreadDiscount() {
        BigDecimal discount = soupOffer.calculateDiscount(asList(SOUP, SOUP, SOUP, SOUP, SOUP, SOUP, BREAD), LocalDateTime.now());

        assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.80));
    }

    @Test
    public void whenBasketHasNoAnyItem_thenCalculateBreadDiscountAsZero() {
        BigDecimal discount = soupOffer.calculateDiscount(new ArrayList<>(), LocalDateTime.now());

        assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void whenBasketHasOnlyOneSoup_thenCalculateBreadDiscountAsZero() {
        BigDecimal discount = soupOffer.calculateDiscount(asList(SOUP, BREAD), LocalDateTime.now());

        assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void whenShoppingDateIsBeforeThanOfferStartDate_thenCalculateBreadDiscountAsZero() {
        BigDecimal discount = soupOffer.calculateDiscount(asList(SOUP, SOUP, BREAD), LocalDateTime.now().minusDays(2));

        assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void whenShopingDateIsAfterThanOfferEndDate_thenCalculateBreadDiscountAsZero() {
        BigDecimal discount = soupOffer.calculateDiscount(asList(SOUP, SOUP, BREAD), LocalDateTime.now().plusDays(8));

        assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }

}