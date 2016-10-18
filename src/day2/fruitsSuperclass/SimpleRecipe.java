package day2.fruitsSuperclass;

import java.math.BigDecimal;
import java.util.Collection;

public class SimpleRecipe {
	String name;
	Collection<String> ingredients;
	BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Collection<String> ingredients) {
		this.ingredients = ingredients;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
