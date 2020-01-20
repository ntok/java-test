package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class ShoppingCalculator {

    private List<String> items;

    public BigDecimal calculate(LocalDateTime now) {
        return null;
    }
}
