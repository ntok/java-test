package com.henrysgrocery;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static com.henrysgrocery.Item.APPLE;
import static java.util.Collections.singletonList;

public class AppleOfferTest {

    @Test
    public void whenBasketHasApple_thenCalculateDiscount() {
        BigDecimal discount = new AppleOffer().calculateDiscount(singletonList(APPLE), LocalDateTime.now().plusDays(4));

        Assertions.assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.01));
    }

    @Test
    public void whenBasketHasMultipleApple_thenCalculateDiscount()  {
        BigDecimal discount = new AppleOffer().calculateDiscount(Arrays.asList(APPLE,APPLE,APPLE), LocalDateTime.now().plusDays(4));

        Assertions.assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.03));
    }

}