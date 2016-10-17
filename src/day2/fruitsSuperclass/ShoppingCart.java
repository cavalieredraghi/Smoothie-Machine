package day2.fruitsSuperclass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ShoppingCart {
	Scanner input = new Scanner(System.in);
	String option;
	private Collection<ShoppingCart> cart = new ArrayList();

	public Collection addProduct() {
		
		System.out.println("1)Banana Smoothie\n" + "2)Bananberry Classic\n" + "3)Pineapple Smoothie\n"
				+ "4)Tropical Fusion\n" + "5)Indiana Special \n" + "6)Green Soup");
		System.out.print("> ");
		option=input.nextLine();
		if (option.equals("1")){
			
		}
	}
}
