package com.henrysgrocery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.henrysgrocery.Item.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCalculatorTest {

    @Mock
    private SoupOffer soupOffer;

    @Test
    public void whenNoDiscountApplied_thenCalculateShoppingCost() {
        when(soupOffer.calculateDiscount(anyList(), any())).thenReturn(BigDecimal.valueOf(0.0));

        BigDecimal calculation = new ShoppingCalculator(asList(SOUP, BREAD, MILK), soupOffer).calculate(LocalDateTime.now());

        assertThat(calculation).isEqualTo(BigDecimal.valueOf(2.75));
    }

    @Test
    public void whenItemListIsEmpty_thenCalculateShoppingCostAsZero() {
        when(soupOffer.calculateDiscount(anyList(), any())).thenReturn(BigDecimal.valueOf(0.0));

        BigDecimal calculation = new ShoppingCalculator(new ArrayList<>(), soupOffer).calculate(LocalDateTime.now());

        assertThat(calculation).isEqualByComparingTo(BigDecimal.valueOf(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenItemListIsNull_thenCalculateShoppingCostAsZero() {
        new ShoppingCalculator(null, soupOffer).calculate(LocalDateTime.now());
    }

    @Test
    public void whenBuySoupGetHalfBreadDiscountApplied_thenCalculateShoppingCost() {
        when(soupOffer.calculateDiscount(anyList(), any())).thenReturn(BigDecimal.valueOf(0.4));
        List<Item> items = asList(SOUP, SOUP, BREAD, MILK);

        LocalDateTime shoppingDate = LocalDateTime.now();
        BigDecimal calculation = new ShoppingCalculator(items, soupOffer).calculate(shoppingDate);

        assertThat(calculation).isEqualByComparingTo(BigDecimal.valueOf(3.00));
        verify(soupOffer).calculateDiscount(items, shoppingDate);
    }

}