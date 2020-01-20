package com.henrysgrocery;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum Item {
    SOUP("SOUP", BigDecimal.valueOf(0.65)),
    APPLE("APPLE",BigDecimal.valueOf(0.10)),
    BREAD("BREAD",BigDecimal.valueOf(0.80)),
    MILK("MILK",BigDecimal.valueOf(1.30));

    private String name;
    private BigDecimal price;

    Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
