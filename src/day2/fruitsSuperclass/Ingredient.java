package day2.fruitsSuperclass;

public interface Ingredient {
public default String getName(){
	return null;
 }
public default double getPrice(){
	return 0;
	
}
}
