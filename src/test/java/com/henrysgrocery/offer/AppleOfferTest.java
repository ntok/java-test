package com.henrysgrocery.offer;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.henrysgrocery.item.Item.*;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class AppleOfferTest {

    private AppleOffer appleOffer;

    @Before
    public void setUp() {
        appleOffer = new AppleOffer(LocalDateTime.now().plusDays(3), LocalDateTime.now().plusMonths(1).with(lastDayOfMonth()));
    }

    @Test
    public void whenBasketHasApple_thenCalculateDiscount() {
        BigDecimal discount = appleOffer.calculateDiscount(singletonList(APPLE), LocalDateTime.now().plusDays(4));

        Assertions.assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.01));
    }

    @Test
    public void whenBasketHasMultipleApple_thenCalculateDiscount() {
        BigDecimal discount = appleOffer.calculateDiscount(asList(APPLE, APPLE, APPLE), LocalDateTime.now().plusDays(4));

        Assertions.assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.03));
    }

    @Test
    public void whenBasketHasNoApple_thenCalculateDiscountAsZero() {
        BigDecimal discount = appleOffer.calculateDiscount(asList(MILK, BREAD), LocalDateTime.now().plusDays(4));
        Assertions.assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void whenBasketHasNoItem_thenCalculateDiscountAsZero() {
        BigDecimal discount = appleOffer.calculateDiscount(new ArrayList<>(), LocalDateTime.now().plusDays(4));
        Assertions.assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void whenShoppingDateIsBeforeThanOfferStartDate_thenCalculateDiscountAsZero() {
        BigDecimal discount = appleOffer.calculateDiscount(singletonList(APPLE), LocalDateTime.now().minusDays(2));
        Assertions.assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void whenShoppingDateIsAfterThanOfferEndDate_thenCalculateDiscountAsZero() {
        BigDecimal discount = appleOffer.calculateDiscount(singletonList(APPLE), LocalDateTime.now().plusMonths(2));
        Assertions.assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }

}