package com.henrysgrocery;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCalculatorTest {

    @Test
    public void whenNoDiscountApplied_thenCalculateShoppingCost() {
        List<String> shoppingItems = new ArrayList<String>();
        shoppingItems.add("SOUP");
        shoppingItems.add("BREAD");
        shoppingItems.add("MILK");
        BigDecimal calculation =  new ShoppingCalculator(shoppingItems).calculate();
        assertThat(calculation).isEqualTo(BigDecimal.valueOf(2.75));
    }

    @Test
    public void whenItemListIsEmpty_thenCalculateShoppingCostAsZero() {
        BigDecimal calculation = new ShoppingCalculator(new ArrayList<String>()).calculate();
        assertThat(calculation).isEqualTo(BigDecimal.valueOf(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenItemListIsNull_thenCalculateShoppingCostAsZero() {
        new ShoppingCalculator(null).calculate();
    }


}