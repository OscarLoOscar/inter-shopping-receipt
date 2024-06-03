package com.example;

public class Product {
  private String name;
  private double price;
  private ProductCategory category;

  public Product(String name, double price, ProductCategory category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public ProductCategory getCategory() {
    return category;
  }
}
