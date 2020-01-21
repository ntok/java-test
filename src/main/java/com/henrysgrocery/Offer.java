package com.henrysgrocery;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface Offer {

    BigDecimal calculateDiscount(List<Item> shoppingList, LocalDateTime shoppingDate);

    default long getItemCount(List<Item> shoppingList, Item searchItem) {
        return shoppingList.stream().filter(item -> item.equals(searchItem)).count();
    }
}
