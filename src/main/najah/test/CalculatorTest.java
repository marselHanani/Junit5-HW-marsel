package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.najah.code.Calculator;

@DisplayName("Calculator Tests")
public class CalculatorTest {
    
    Calculator calc;

    @BeforeEach
    void setUp(){
        calc = new Calculator();
        System.out.println("SetUp Complete");
    }

    @Test
    @Order(1)
    @DisplayName("Valid Number - Add Method")
    void addMethodTestValid() {
        try {
            assertEquals(5, calc.add(2, 3));
            assertEquals(10, calc.add(1, 2, 3, 4)); 
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Invalid Number - Add Method")
    void addMethodTestInvalid() {
        try {
            assertNotEquals(7, calc.add(2, 3)); 
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    @Order(3)
    @DisplayName("Add Test - Negative Numbers")
    void addTestNegative() {
    	assertEquals(-1, calc.add(-2, 1)); 
    	assertEquals(-6, calc.add(-3, -3)); 
    }
    
    @Test
    @Order(5)
    @Disabled("This test is failing. It will be fixed by adjusting the expected value.")
    @DisplayName("Intentionally Failing Test")
    void DisabledFailingTest() {
        assertEquals(11, calc.add(5, 5), "This test is intentionally failing.");
    }
    
    @DisplayName("Factorial Test - Valid")
    @ParameterizedTest
    @CsvSource({
        "2, 2",
        "4, 24",
        "5, 120"
    })
    void factorialMethodTest(int number, int expected) {
        assertEquals(expected, calc.factorial(number));
    }

    @Test
    @DisplayName("Factorial Test - Negative Number")
    void factorialMethodTestNegative() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-1), "Negative input should throw exception");
    }

    @Test
    @DisplayName("TimeOut Test")
    @Timeout(value = 100 , unit = TimeUnit.MILLISECONDS)
    void factorialTimeOutTest() throws InterruptedException {
        Thread.sleep(10);
        calc.factorial(5000); 
    }

    @Test
    @DisplayName("Divide Test")
    void divideTest() {
        assertEquals(2, calc.divide(10, 5));  
        assertEquals(3, calc.divide(9, 3)); 
        assertEquals(0, calc.divide(0, 5));   

        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0), "Cannot divide by zero");
    }

    @Test
    @DisplayName("Divide Test - Negative Numbers")
    void divideTestNegative() {
        assertEquals(-5, calc.divide(-10, 2)); 
        assertEquals(-5, calc.divide(10, -2)); 
    }


    @Test
    @DisplayName("Factorial Test at 0")
    void factorialTestZero() {
        assertEquals(1, calc.factorial(0));  
    }

}
