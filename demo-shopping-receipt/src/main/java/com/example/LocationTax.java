package com.example;

public enum LocationTax {
  CA(9.75), //
  NY(8.875)//
  ;

  private LocationTax(double taxRate) {
    this.taxRate = taxRate;
  }

  double taxRate;

  public double getTaxRate() {
    return taxRate;
  }
}
