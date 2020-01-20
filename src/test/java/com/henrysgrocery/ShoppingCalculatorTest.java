package com.henrysgrocery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCalculatorTest {

    @Mock
    private SoupOffer soupOffer;

    @Test
    public void whenNoDiscountApplied_thenCalculateShoppingCost() {
        List<String> shoppingItems = new ArrayList<String>();
        shoppingItems.add("SOUP");
        shoppingItems.add("BREAD");
        shoppingItems.add("MILK");
        BigDecimal calculation =  new ShoppingCalculator(shoppingItems, soupOffer).calculate();
        assertThat(calculation).isEqualTo(BigDecimal.valueOf(2.75));
    }

    @Test
    public void whenItemListIsEmpty_thenCalculateShoppingCostAsZero() {
        BigDecimal calculation = new ShoppingCalculator(new ArrayList<String>(),soupOffer).calculate();
        assertThat(calculation).isEqualByComparingTo(BigDecimal.valueOf(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenItemListIsNull_thenCalculateShoppingCostAsZero() {
        new ShoppingCalculator(null, new SoupOffer()).calculate();
    }

    @Test
    public void whenBuySoupGetHalfBreadDiscountApplied_thenCalculateShoppingCost() {
        when(soupOffer.calculateDiscount(anyList())).thenReturn(BigDecimal.valueOf(0.4));
        List<String> shoppingItems = new ArrayList<String>();
        shoppingItems.add("SOUP");
        shoppingItems.add("SOUP");
        shoppingItems.add("BREAD");
        shoppingItems.add("MILK");
        BigDecimal calculation = new ShoppingCalculator(shoppingItems,soupOffer).calculate();
        verify(soupOffer).calculateDiscount(shoppingItems);
        assertThat(calculation).isEqualByComparingTo(BigDecimal.valueOf(3.00));
    }

}