package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShoppingCartReceipt {
  public static void main(String[] args) {
    // Create products
    Product book = new Product("book", 17.99, ProductCategory.OTHER);
    Product chips = new Product("potato chips", 3.99, ProductCategory.FOOD);
    Product pencil = new Product("pencil", 2.99, ProductCategory.OTHER);
    Product shirt = new Product("shirt", 29.99, ProductCategory.CLOTHING);

    // Create shopping cart items
    ShoppingCartItem item1 = new ShoppingCartItem(book, 1);
    ShoppingCartItem item2 = new ShoppingCartItem(chips, 1);
    ShoppingCartItem item3 = new ShoppingCartItem(pencil, 3);
    ShoppingCartItem item4 = new ShoppingCartItem(pencil, 2);
    ShoppingCartItem item5 = new ShoppingCartItem(shirt, 1);

    // Create shopping cart
    ShoppingCart CAcart = new ShoppingCart();
    CAcart.addItem(item1);
    CAcart.addItem(item2);
    ShoppingCart NYcart1 = new ShoppingCart();
    NYcart1.addItem(item1);
    NYcart1.addItem(item3);
    ShoppingCart NYcart2 = new ShoppingCart();
    NYcart2.addItem(item4);
    NYcart2.addItem(item5);

    // Calculate sales tax and print receipt
    SalesTaxCalculator taxCalculator = new SalesTaxCalculator();
    printReceipt(LocationTax.CA, CAcart, taxCalculator);
    printReceipt(LocationTax.NY, NYcart1, taxCalculator);
    printReceipt(LocationTax.NY, NYcart2, taxCalculator);

  }

  private static void printReceipt(LocationTax location, ShoppingCart cart,
      SalesTaxCalculator taxCalculator) {
    BigDecimal subtotal = cart.calculateSubtotal();
    BigDecimal totalTax = BigDecimal.ZERO;
    System.out.println("Location:      " + location);
    System.out.println("item            price          qty");

    for (ShoppingCartItem item : cart.getItems()) {
      BigDecimal tax = taxCalculator.calculateSalesTax(location,
          item.getProduct(), item.getQuantity());
      totalTax = totalTax.add(tax);
      System.out.printf("%-15s $%-10.2f      %d%n", item.getProduct().getName(),
          item.getProduct().getPrice(), item.getQuantity());
    }

    BigDecimal total = subtotal.add(totalTax);
    System.out.printf("%-27s $%-8.2f%n", "subtotal:", subtotal);
    System.out.printf("%-28s $%-8.2f%n", "tax:", totalTax);
    System.out.printf("%-27s $%-8.2f%n", "total:", total);
    System.out.println();
  }
}
