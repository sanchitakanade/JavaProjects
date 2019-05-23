/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

/**
 * Program creates a HashTable and adds 10 Food items in it using insert(Food) method
 * and calls remove(Food) and search(Food) methods to remove and search different 
 * food objects with same calories.
 * Program calls display() method to print out all items in the HashTable.
 * This class contains program's main method.
 * @author Sanchita Kanade
 */
public class HolidayDinner {

	/**
	 * Creates 10 Food objects using parameterized constructor.
	 * Creates a HashTable and inserts all Food items in it using insert(Food) method.
	 * Calls remove(Food) and search(Food) methods to remove and search different 
	 * food objects with same calories.
	 * Calls display() method to print out all items in the HashTable.
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		//Creating 10 Food objects using parameterized constructor.  
		Food apple = new Food("Apple",449);
		Food orange = new Food("Orange",351);
		Food milk = new Food("Milk",153);
		Food burger = new Food("Burger",224);
		Food taco = new Food("Taco",500);
		Food quesadilla = new Food("Quesadilla",449);
		Food fajita = new Food("Fajita",255);
		Food celery = new Food("Celery",557);
		Food pasta = new Food("Pasta",328);
		Food pizza = new Food("Pizza",449);

		//Creating a HashTable to hold 10 Food objects.
		HolidayHash foodTable = new HolidayHash();

		// Inserting 10 Food items into the HashtTable using insert(Food) method.
		foodTable.insert(apple);
		foodTable.insert(orange);
		foodTable.insert(milk);
		foodTable.insert(burger);
		foodTable.insert(taco);
		foodTable.insert(quesadilla);
		foodTable.insert(fajita);
		foodTable.insert(celery);
		foodTable.insert(pasta);
		foodTable.insert(pizza);

		//Invokes display() method to print out all items in the HashTable.
		foodTable.display();

		//Invokes remove(Food) method to remove a Food item from the HashTable.
		foodTable.remove(apple);

		//Invokes display() method to print out all items in the HashTable, after removing apple.
		foodTable.display();

		//Invokes search(Food) method to search a Food item into the HashTable.
		Food searchPizza = foodTable.search(pizza);

		if (searchPizza != null) {
			System.out.println("\nFood Item found: Name: " + searchPizza.getName() + " Calories: "+searchPizza.getCalories() );
		}
		else {
			System.out.println("\nFood Item not found");
		}
	}
}
