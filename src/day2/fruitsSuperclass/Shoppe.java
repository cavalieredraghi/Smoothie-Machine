package day2.fruitsSuperclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Shoppe {
	public static void main(String[] args) throws IOException {
		ReadRecipes readRecipes = new ReadRecipes();
		// add a second file for the price of the products allow it to be read
		// and in able it to be before the ingredients
		final Collection<SimpleRecipe> recipes = readRecipes.loadRecipes("Recipes.csv");
		final Collection<SimpleRecipe> prices = readRecipes.loadRecipes("RecipePrice.csv");
		final Collection<SimpleRecipe> ingredients = readRecipes.loadRecipes("Ingredients.csv");

		Scanner input = new Scanner(System.in);
		String option;
		System.out.println("Welcome to Smooth Moves: What Smoothie would you like to day?\n");
		while (true) {

			System.out.println("Please select from the list of options: \n" + "1) create custom smoothie\n"
					+ "2) recipe prices\n" + "3) recipes ingredients list\n" + "x) to exit.");
			System.out.print("> ");
			option = input.nextLine();
			
			if (option.equals("1")) {
				for (SimpleRecipe Ingredient : ingredients) {
				System.out.println(Ingredient.getName()+": Price: " + Ingredient.getIngredients());
				}
				File dir = new File ("/user/bigge/workspace/Smoothie");
				File file = new File ("custom_smoothie.cvs");
				
				FileOutputStream outFile = new FileOutputStream(file);
				String s;
				do{
					System.out.println("To escape just hit enter on a blank line.");
					System.out.print("> ");
					s = input.nextLine();
				outFile.write(s.getBytes());
				}while (!"".equals(s));
			}
			if (option.equals("2")) {
				for (SimpleRecipe price : prices) {
					System.out.println(price.getName());
					System.out.println("Price: " + price.getIngredients());
				}
			}
			if (option.equals("3")) {
				for (SimpleRecipe recipe : recipes) {
					System.out.println(recipe.getName());
					System.out.println(recipe.getIngredients());
				}
			}

			if (option.equalsIgnoreCase("X")) {
				break;

			}
		}

	}

	public Collection<SimpleRecipe> loadRecipes(String filename) {
		final File recipeFile = new File(filename);
		final Collection<SimpleRecipe> recipes = new ArrayList<>();

		final InputStream recipeStream;
		try {
			recipeStream = new FileInputStream(recipeFile);
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the file: " + recipeFile.getAbsolutePath());
			return recipes;
		}
		try (Scanner input = new Scanner(recipeStream)) {
			while (input.hasNextLine()) {
				String[] Items = input.nextLine().split(",");
				recipes.add(buildRecipe(Items));
			}
		}
		return recipes;
	}

	public SimpleRecipe buildRecipe(String[] items) {
		SimpleRecipe recipe = new SimpleRecipe();
		recipe.setName(items[0]);

		Collection<String> ingredients = new ArrayList<>();
		for (int i = 1; i < items.length; i++) {
			ingredients.add(items[i]);
		}
		recipe.setIngredients(ingredients);
		return recipe;
	}

	public SimpleRecipe priceRecipe(BigDecimal[] items) {
		SimpleRecipe recipe = new SimpleRecipe();
		recipe.setPrice(items[1]);
		return recipe;
	}
}
