package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import main.najah.code.UserService;

@Execution(ExecutionMode.CONCURRENT)
class UserServiceSimpleTest {
	 private UserService userService;
	  @BeforeEach
	    void BeforeSetUpEach() {
	        userService = new UserService();  
	    }
	  @AfterEach
	    void ArterSetupEach() {
	        System.out.println("The Test completed.");
	    }
	  @BeforeAll
	    static void BeforeSetupAll() {
	        System.out.println("Initializing tests...");
	    }

	    @AfterAll
	    static void AfterSetupAll() {
	        System.out.println("All tests completed.");
	    }
	    @Test
	    @DisplayName("Valid Email")
	    void validEmailTest() {
	        assertTrue(userService.isValidEmail("test@example.com"), "The email should be valid");
	    }

	    @Test
	    @DisplayName("Invalid Email")
	    void invalidEmailMissingAtTest() {
	        assertFalse(userService.isValidEmail("testexample.com"), "The email should be invalid (missing @)");
	    }

	    @Test
	    @DisplayName("Invalid Email Without dot")
	    void invalidEmailMissingDotTest() {
	        assertFalse(userService.isValidEmail("test@examplecom"), "The email should be invalid (missing dot)");
	    }

	    @Test
	    @DisplayName("Invalid Email (Null Email)")
	    void invalidEmailNullTest() {
	        assertFalse(userService.isValidEmail(null), "The email should be invalid (null email)");
	    }

	    @Test
	    @DisplayName("Valid Authentication Test")
	    void validAuthenticationTest() {
	        assertTrue(userService.authenticate("admin", "1234"), "The user should be authenticated");
	    }

	    @Test
	    @DisplayName("Invalid Authentication (Wrong Username)")
	    void invalidAuthenticationWrongUsernameTest() {
	        assertFalse(userService.authenticate("user", "1234"), "Authentication should fail due to incorrect username");
	    }

	    @Test
	    @DisplayName("Invalid Authentication (Wrong Password)")
	    void invalidAuthenticationWrongPasswordTest() {
	        assertFalse(userService.authenticate("admin", "wrongPassword"), "Authentication should fail due to incorrect password");
	    }

	    @Test
	    @DisplayName("Invalid Authentication (Wrong both)")
	    void invalidAuthenticationWrongCredentialsTest() {
	        assertFalse(userService.authenticate("user", "wrongPassword"), "Authentication should fail due to both incorrect username and password");
	    }
	}
	

