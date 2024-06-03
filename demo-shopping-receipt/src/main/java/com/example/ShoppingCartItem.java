package com.example;

import java.math.BigDecimal;

public class ShoppingCartItem {
  private Product product;
  private int quantity;

  public ShoppingCartItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getItemTotal() {
    return BigDecimal.valueOf(product.getPrice())//
        .multiply(BigDecimal.valueOf(quantity))//
        .doubleValue();
  }
}
