/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

/**
 * This class is an implementation of a HashTable.
 * This class contains insert(Food), search(Food) and remove(Food) methods 
 * to insert a food item, search a food item and remove a food item from the Hashtable respectively.
 * @author Sanchita Kanade
 */
public class HolidayHash {

	private static final int ARRAY_SIZE = 10;

	// creating a array of SingleList class
	SingleList[] sLLArray = new SingleList[ARRAY_SIZE];

	/**
	 * Default constructor creating a new SingleList object for each index of Singlelist[]
	 */
	public HolidayHash() {
		for(int i = 0; i < ARRAY_SIZE; i++) {
			sLLArray[i] = new SingleList();
		}
	}

	/**
	 * This method inserts a food object into the Hashtable.
	 * @param food represents a food item.
	 */
	public void insert(Food food) {
		int calories = food.getCalories();
		int hash = calories % ARRAY_SIZE;
		SingleList list = sLLArray[hash];
		list.add(food);
	}

	/**
	 * This method search for a food object into the HashTable. 
	 * and returns it if found.
	 * @param food represents a food item. 
	 * @return returns a Food object.
	 */
	public Food search(Food food) {
		int calories = food.getCalories();
		int hash = calories % ARRAY_SIZE;
		SingleList list = sLLArray[hash];
		Node foodNode = list.search(food);
		return foodNode == null ? null : foodNode.foodItem;
	}

	/**
	 * This method removes a food object from the Hashtable.
	 * @param food represents a food item.
	 */
	public void remove(Food food) {
		int calories = food.getCalories();
		int hash = calories % ARRAY_SIZE;
		SingleList list = sLLArray[hash];
		list.remove(food);
	}

	/**
	 * This method displays all items in the HashTable.
	 */
	public void display() {
		System.out.println("\nFood Items in Hash Table");
		for(SingleList s : sLLArray) {
			s.print();
		}
	}
}
