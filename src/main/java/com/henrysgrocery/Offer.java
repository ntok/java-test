package com.henrysgrocery;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface Offer {

    BigDecimal calculateDiscount(List<Item> shoppingList, LocalDateTime shoppingDate);
}
