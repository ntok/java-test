package com.henrysgrocery;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.henrysgrocery.Item.BREAD;
import static com.henrysgrocery.Item.SOUP;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class HenrysGroceryAcceptanceTest {
    @Test
    public void whenThreeTinsOfSoupAndTwoBreadToday_thenCalculateCost() {
        SoupOffer soupOffer = new SoupOffer(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(7));
        ShoppingCalculator shoppingCalculator = new ShoppingCalculator(asList(SOUP, SOUP, SOUP, BREAD, BREAD), soupOffer);

        BigDecimal calculation = shoppingCalculator.calculate(LocalDateTime.now());

        assertThat(calculation).isEqualTo(BigDecimal.valueOf(3.15));
    }
}
