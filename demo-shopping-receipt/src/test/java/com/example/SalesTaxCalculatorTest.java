package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalesTaxCalculatorTest {

    private SalesTaxCalculator salesTaxCalculator;

    @BeforeEach
    void setUp() {
        salesTaxCalculator = new SalesTaxCalculator();
    }

    @Test
    void testCalculateSalesTaxForNonExemptProduct() {
        LocationTax location = LocationTax.CA;
        Product product = new Product("Book", 10.0, ProductCategory.BOOK);
        int quantity = 1;

        double expectedTaxAmount = 1.0;
        double actualTaxAmount = salesTaxCalculator
                .calculateSalesTax(location, product, quantity).doubleValue();

        assertEquals(expectedTaxAmount, actualTaxAmount);
    }

    @Test
    void testCalculateSalesTaxForExemptProduct() {
        LocationTax location = LocationTax.CA;
        Product product = new Product("Apple", 1.0, ProductCategory.FOOD);
        int quantity = 5;

        double expectedTaxAmount = 0.0;
        double actualTaxAmount = salesTaxCalculator
                .calculateSalesTax(location, product, quantity).doubleValue();

        assertEquals(expectedTaxAmount, actualTaxAmount);
    }

    @Test
    void testCalculateSalesTaxForRoundedAmount() {
        LocationTax location = LocationTax.NY;
        Product product = new Product("Shirt", 20.0, ProductCategory.CLOTHING);
        int quantity = 2;

        double expectedTaxAmount = 0.0;
        double actualTaxAmount = salesTaxCalculator
                .calculateSalesTax(location, product, quantity).doubleValue();

        assertEquals(expectedTaxAmount, actualTaxAmount);
    }
}
