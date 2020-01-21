package com.henrysgrocery;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.henrysgrocery.Item.*;
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
        BigDecimal calculation = new ShoppingCalculator(asList(SOUP, SOUP, SOUP, BREAD, BREAD), discountCalculators)
                .calculate(LocalDateTime.now());

        assertThat(calculation).isEqualTo(BigDecimal.valueOf(3.15));
    }

    @Test
    public void whenSixApplesAndSingleMilkToday_thenCalculateCost() {
        BigDecimal calculation = new ShoppingCalculator(asList(APPLE, APPLE, APPLE, APPLE, APPLE, APPLE, MILK), discountCalculators)
                .calculate(LocalDateTime.now());

        assertThat(calculation).isEqualTo(BigDecimal.valueOf(1.90));
    }

}
