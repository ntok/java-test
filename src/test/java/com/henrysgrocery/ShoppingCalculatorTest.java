package com.henrysgrocery;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCalculatorTest {

    @Test
    public void whenNoDiscountApplied_thenCalculateShoppingCost(){
        List<String> shoppingItems=new ArrayList<String>();
        shoppingItems.add("SOUP");
        shoppingItems.add("BREAD");
        shoppingItems.add("MILK");
        ShoppingCalculator shoppingCalculator = new ShoppingCalculator(shoppingItems);
        BigDecimal calculation = shoppingCalculator.calculate(LocalDateTime.now());
        assertThat(calculation).isEqualTo(BigDecimal.valueOf(2.75));
    }

}