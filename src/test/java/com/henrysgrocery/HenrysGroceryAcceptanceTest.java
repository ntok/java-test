package com.henrysgrocery;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HenrysGroceryAcceptanceTest {
    @Test
    public void whenThreeTinsOfSoupAndTwoBreadToday_thenCalculateCost() {
        List<String> shoppingItems=new ArrayList<String>();
        shoppingItems.add("SOUP");
        shoppingItems.add("SOUP");
        shoppingItems.add("SOUP");
        shoppingItems.add("BREAD");
        shoppingItems.add("BREAD");
        ShoppingCalculator shoppingCalculator = new ShoppingCalculator(shoppingItems);
        BigDecimal calculation = shoppingCalculator.calculate();
        assertThat(calculation).isEqualTo(BigDecimal.valueOf(3.15));
    }
}
