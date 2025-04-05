package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;
import main.najah.code.RecipeException;

class RecipeBookTest {
	 private RecipeBook recipeBook;
	    private Recipe recipe1;
	    private Recipe recipe2;

	    @BeforeEach
	    void setUp() throws RecipeException {
	        recipeBook = new RecipeBook(); 
	        recipe1 = new Recipe();        
	        recipe2 = new Recipe();       

	        recipe1.setName("Espresso");
	        recipe1.setPrice("5");
	        recipe1.setAmtCoffee("3");
	        recipe1.setAmtMilk("0");
	        recipe1.setAmtSugar("1");
	        recipe1.setAmtChocolate("0");

	        recipe2.setName("Latte");
	        recipe2.setPrice("6");
	        recipe2.setAmtCoffee("2");
	        recipe2.setAmtMilk("3");
	        recipe2.setAmtSugar("1");
	        recipe2.setAmtChocolate("1");
	    }

	    @Test
	    @DisplayName("Add Recipe Test")
	    void addRecipeTest() {
	        assertTrue(recipeBook.addRecipe(recipe1), "Recipe should be added successfully");
	        assertEquals(1, recipeBook.getRecipes().length, "The recipe should be added to the recipeBook");
	    }


	    @Test
	    @DisplayName("Dublicate Recipe")
	    void addRecipeDuplicateTest() {
	        recipeBook.addRecipe(recipe1);
	        assertFalse(recipeBook.addRecipe(recipe1), "Duplicate recipes should not be added");
	    }

	    @Test
	    @DisplayName("Delete Recipe Test")
	    void deleteRecipeTest() {
	        recipeBook.addRecipe(recipe1);
	        assertEquals("Espresso", recipeBook.deleteRecipe(0), "The recipe should be deleted successfully");
	    }

	    @Test
	    @DisplayName("Delete Invalid Index Recipe")
	    void deleteRecipeInvalidIndexTest() {
	        assertNull(recipeBook.deleteRecipe(2), "Trying to delete a recipe at an invalid index should return null");
	    }

	    @Test
	    @DisplayName("Edit Recipe Test")
	    void editRecipeTest() throws RecipeException {
	        recipeBook.addRecipe(recipe1);
	        Recipe newRecipe = new Recipe();
	        newRecipe.setName("Cappuccino");
	        newRecipe.setPrice("7");
	        assertEquals("Espresso", recipeBook.editRecipe(0, newRecipe), "The recipe should be edited successfully");
	    }

	    @Test
	    @DisplayName("Edit Invalid Index Recipe Test")
	    void editRecipeInvalidIndexTest() throws RecipeException {
	        Recipe newRecipe = new Recipe();
	        newRecipe.setName("Cappuccino");
	        newRecipe.setPrice("7");
	   
	    }

}
