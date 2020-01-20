package com.henrysgrocery;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class ShoppingCalculator {

    private List<String> items;

    public BigDecimal calculate() {
        if(items==null){
            throw new IllegalArgumentException("Shopping items is null");
        }
        return items.stream()
                .map(s->Item.valueOf(s.toUpperCase()).getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
