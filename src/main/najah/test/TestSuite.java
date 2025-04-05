package main.najah.test;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.jupiter.api.BeforeAll;

@Suite
@SelectPackages({"main.najah.test"})  
public class TestSuite {

    @BeforeAll
    static void setUp() {
        System.out.println("Setting up the test suite...");
    }
}
