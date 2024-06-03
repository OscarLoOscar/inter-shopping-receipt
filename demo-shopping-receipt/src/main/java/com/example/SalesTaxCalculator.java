package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesTaxCalculator {

  public BigDecimal calculateSalesTax(LocationTax location, Product product,
      int quantity) {
    BigDecimal salesTaxRate = BigDecimal.valueOf(location.getTaxRate());
    if (isTaxExempt(product.getCategory(), location)) {
      salesTaxRate = BigDecimal.ZERO;
    }
    BigDecimal taxAmount = BigDecimal.valueOf(product.getPrice())
        .multiply(BigDecimal.valueOf(quantity)).multiply(salesTaxRate)
        .divide(BigDecimal.valueOf(100));
    return roundUpToNearestFiveCents(taxAmount);
    // return (taxAmount);

  }

  private boolean isTaxExempt(ProductCategory category, LocationTax location) {
      if (location.equals(LocationTax.CA)
          && category.equals(ProductCategory.FOOD)) {
        return true;
      }
      if (location.equals(LocationTax.NY)
          && (category.equals(ProductCategory.FOOD)
              || category.equals(ProductCategory.CLOTHING))) {
        return true;
      }
    return false;
  }

  private BigDecimal roundUpToNearestFiveCents(BigDecimal amount) {
    return amount.setScale(2, RoundingMode.UP)
    .divide(new BigDecimal("0.05"), 0, RoundingMode.UP)
    .multiply(new BigDecimal("0.05"));
  }
}
