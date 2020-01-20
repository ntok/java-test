package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class ShoppingCalculator {

    private List<String> items;

    public BigDecimal calculate() {
        return items.stream()
                .map(s->Item.valueOf(s.toUpperCase()).getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
