package com.henrysgrocery;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.henrysgrocery.Item.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class HenrysGroceryAcceptanceTest {

    private List<Offer> offers;

    @Before
    public void setUp() {
        offers = asList(new SoupOffer(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(7)),
                new AppleOffer());
    }

    @Test
    public void whenThreeTinsOfSoupAndTwoBreadToday_thenCalculateCost() {
        BigDecimal calculation = new ShoppingCalculator(asList(SOUP, SOUP, SOUP, BREAD, BREAD), offers)
                .calculate(LocalDateTime.now());

        assertThat(calculation).isEqualTo(BigDecimal.valueOf(3.15));
    }

    @Test
    public void whenSixApplesAndSingleMilkToday_thenCalculateCost() {
        BigDecimal calculation = new ShoppingCalculator(asList(APPLE, APPLE, APPLE, APPLE, APPLE, MILK), offers)
                .calculate(LocalDateTime.now());

        assertThat(calculation).isEqualTo(BigDecimal.valueOf(1.90));
    }

}
