package com.henrysgrocery;

import org.junit.Test;

import java.math.BigDecimal;

import static com.henrysgrocery.Item.BREAD;
import static com.henrysgrocery.Item.SOUP;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class HenrysGroceryAcceptanceTest {
    @Test
    public void whenThreeTinsOfSoupAndTwoBreadToday_thenCalculateCost() {
        ShoppingCalculator shoppingCalculator = new ShoppingCalculator(asList(SOUP, SOUP, SOUP, BREAD, BREAD), new SoupOffer());

        BigDecimal calculation = shoppingCalculator.calculate();

        assertThat(calculation).isEqualTo(BigDecimal.valueOf(3.15));
    }
}
