package day2.fruitsSuperclass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ShoppingCart {
	Scanner input = new Scanner(System.in);
	String option;
	ReadRecipes readRecipes = new ReadRecipes();
	private Collection<ShoppingCart> cart = new ArrayList();
	final Collection<SimpleRecipe> prices = readRecipes.loadRecipes("RecipePrice.csv");
	
	public void addProduct() {
		while (true) {
			System.out.println("Which Smoothie would you like to purchase?");
			System.out.print("> ");
			// may need a loop while loop most likely best for loop then add in 
			//if coditionals you will need 3 for loops all linked to one another 
			//through user input.
			while(true){
			option = input.nextLine();
			 for(i=1; 1>)
			}
		}

	}

	public void cartLocation() {
		
		
	}
}
