package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.najah.code.Product;

public class ProductTest {
    Product p;

    @BeforeEach
    void setUp() {
        p = new Product("Test Product", 100);
    }

    @Test
    @DisplayName("Product Creation Test")
    void productCreationTest() {
        assertEquals("Test Product", p.getName());
        assertEquals(100, p.getPrice());
        assertEquals(0, p.getDiscount());
    }

    @Test
    @DisplayName("Price Test")
    void negativePriceTest() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Invalid Product", -10),
                "Price must be non-negative");
    }

    @Test
    @DisplayName("Discount Test")
    void validDiscountTest() {
        p.applyDiscount(20);
        assertEquals(20, p.getDiscount());
        assertEquals(80, p.getFinalPrice(), "The final price should be 80 after a 20% discount");
    }

    @Test
    @DisplayName("Negative Discount")
    void invalidDiscountNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> p.applyDiscount(-5),
                "Invalid discount");
    }

    @Test
    @DisplayName("Too High Discount")
    void invalidDiscountHighTest() {
        assertThrows(IllegalArgumentException.class, () -> p.applyDiscount(55),"Invalid discount");
    }

    @Test
    @DisplayName("Zero Discount")
    void zeroDiscountTest() {
        p.applyDiscount(0); 
        assertEquals(0, p.getDiscount());
        assertEquals(100, p.getFinalPrice(), "The final price should be 100 after a 0% discount");
    }

    @ParameterizedTest
    @CsvSource({
        "10, 90",
        "25, 75",
        "50, 50" 
    })
    @DisplayName("Parameterized Discount Test")
    void parameterizedDiscountTest(double discount, double expectedFinalPrice) {
        p.applyDiscount(discount);
        assertEquals(discount, p.getDiscount(), "Discount should match");
        assertEquals(expectedFinalPrice, p.getFinalPrice(), "Final price should match");
    }
}


