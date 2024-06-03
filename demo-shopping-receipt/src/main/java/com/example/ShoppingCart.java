package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  private List<ShoppingCartItem> items = new ArrayList<>();

  public void addItem(ShoppingCartItem item) {
    items.add(item);
  }

  public List<ShoppingCartItem> getItems() {
    return items;
  }

  public BigDecimal calculateSubtotal() {
    BigDecimal subtotal = BigDecimal.ZERO;
    for (ShoppingCartItem item : items) {
      subtotal = subtotal.add(BigDecimal.valueOf(item.getItemTotal()));
    }
    return subtotal;
  }
}
