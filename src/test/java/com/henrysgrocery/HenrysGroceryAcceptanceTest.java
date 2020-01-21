package com.henrysgrocery;

import com.henrysgrocery.checkout.ShoppingCheckout;
import com.henrysgrocery.offer.AppleOffer;
import com.henrysgrocery.offer.DiscountCalculator;
import com.henrysgrocery.offer.SoupOffer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.henrysgrocery.item.Item.*;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class HenrysGroceryAcceptanceTest {

    private List<DiscountCalculator> discountCalculators;

    @Before
    public void setUp() {
        discountCalculators = asList(new SoupOffer(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(7)),
                new AppleOffer(LocalDateTime.now().plusDays(3), LocalDateTime.now().plusMonths(1).with(lastDayOfMonth()))
        );
    }

    @Test
    public void whenThreeTinsOfSoupAndTwoBreadToday_thenCalculateCost() {
        BigDecimal cost = new ShoppingCheckout(asList(SOUP, SOUP, SOUP, BREAD, BREAD), discountCalculators)
                .checkout(LocalDateTime.now());

        assertThat(cost).isEqualTo(BigDecimal.valueOf(3.15));
    }

    @Test
    public void whenSixApplesAndSingleMilkToday_thenCalculateCost() {
        BigDecimal cost = new ShoppingCheckout(asList(APPLE, APPLE, APPLE, APPLE, APPLE, APPLE, MILK), discountCalculators)
                .checkout(LocalDateTime.now());

        assertThat(cost).isEqualTo(BigDecimal.valueOf(1.90));
    }

    @Test
    public void whenSixApplesOneMilkInFiveDay_thenCalculateCost() {
        BigDecimal cost = new ShoppingCheckout(asList(APPLE, APPLE, APPLE, APPLE, APPLE, APPLE, MILK), discountCalculators)
                .checkout(LocalDateTime.now().plusDays(5));

        assertThat(cost).isEqualTo(BigDecimal.valueOf(1.84));
    }

    @Test
    public void whenThreeApplesTwoSoupOneBreadInFiveDay_thenCalculateCost() {

        BigDecimal cost = new ShoppingCheckout(asList(APPLE, APPLE, APPLE, SOUP, SOUP, BREAD), discountCalculators)
                .checkout(LocalDateTime.now().plusDays(5));

        assertThat(cost).isEqualTo(BigDecimal.valueOf(1.97));
    }

}
