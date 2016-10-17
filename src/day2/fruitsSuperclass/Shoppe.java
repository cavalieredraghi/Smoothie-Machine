package day2.fruitsSuperclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Shoppe {
	public static void main(String[] args) {
		ReadRecipes readRecipes = new ReadRecipes();

		final Collection<SimpleRecipe> recipes = readRecipes.loadRecipes("recipes.csv");

		Scanner input = new Scanner(System.in);
		String option;
		System.out.println("Welcome to Smooth Moves: What Smoothie would you like to day?\n");
		while (true) {

			System.out.println("Please select from the list of options: \n" + "1) Add items\n" + "2) check out\n"
					+ "3) list of orginal recipes\n" + "x) to exit.");
			System.out.print("> ");
			option = input.nextLine();
			if (option.equals("1")) {
				
			}
			if (option.equals("2")) {
				
			}
			if (option.equals("3")) {
				for (SimpleRecipe recipe : recipes) {
					System.out.println(recipe.getName());
					System.out.println(recipe.getIngredients());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
}
