/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

/**
 * This class has two fields name(String) and calories(int)
 * It contains Overriden toString() method of class Object.
 * @author Sanchita Kanade
 */
public class Food {

	private String name;
	private int calories;

	/**
	 * Parameterized constructor initializing all fields to different values given by the programmer.
	 * @param name represents Food item's name.
	 * @param calories represents calories in Food.
	 */
	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}

	/**
	 * Returns the name.
	 * @return a String value represents Food item's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name field.
	 * @param name represents Food item's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the calories.
	 * @return an integer value represents calories in Food.
	 */
	public int getCalories() {
		return calories;
	}

	/**
	 * Sets the calories field.
	 * @param calories represents calories in Food.
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}

	/**
	 * This method overrides Object's toString() method and
	 * returns a String representation of Food item's name and calories in Food.
	 */
	@Override
	public String toString() {
		return "Food Name: " + name + " Calories: " + calories;
	}
}
