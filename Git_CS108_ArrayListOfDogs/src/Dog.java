/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

/**
 * This class represents Dog object's name, age, height, weight and color.
 * @author Sanchita Kanade
 */
public class Dog {
	private String name;
	private int age;
	private double height;
	private double weight;
	private String color;

	/**
	 * Sets the name field.
	 * @param name represents Dog's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the age field.
	 * @param age represents Dog's age in years.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Sets the height field.
	 * @param height represents Dog's height in inches.
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Sets the weight field.
	 * @param weight represents Dog's weight in pounds.
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Sets the color field.
	 * @param color represents Dog's color.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Returns the name.
	 * @return a String value represents Dog's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the age in years.
	 * @return an integer value represents the age in years.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Returns the height in inches.
	 * @return a double value represents the height in inches.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Returns the weight in pound.
	 * @return a double represents the weight in pound.
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Returns the color.
	 * @return a string represents color of the Dog object.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * prints out the values of all instance variables of the Dog object
	 */
	public void display() {
		System.out.printf("%-8s :  %s\n", "Name" , getName());
		System.out.printf("%-8s :  %d %s\n", "Age" , getAge(), "years");
		System.out.printf("%-8s :  %.1f %s\n","Height" , getHeight() , "inches");
		System.out.printf("%-8s :  %.1f %s\n", "Weight" , getWeight() , "lbs");
		System.out.printf("%-8s :  %s\n","Color" , getColor());
	}

	/**
	 * This method overrides Object's toString method and
	 * returns a String representation of Dog Object.
	 */
	@Override
	public String toString() {
		return "Name     : " + getName() + "\nAge      : " + getAge() + 
				" years" + "\nHeight   : " + getHeight() + " inches" +
				"\nWeight   : " + getWeight() + " lbs" + "\nColor    : " + getColor();
	}

	/**
	 * Default constructor initializing all fields to their default values.
	 */
	public Dog() {
		name = "DOG";
		age = 1;
		height = 5.0;
		weight = 10.0;
		color = null;
	}

	/**
	 * Parameterized constructor initializing all fields to different values given by the programmer.
	 * @param name represents Dog's name.
	 * @param age represents Dog's age in years.
	 * @param height represents Dog's height in inches.
	 * @param weight represents Dog's weight in pounds.
	 * @param color represents Dog's color.
	 */
	public Dog(String name, int age, double height, double weight, String color) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.color = color;
	}
}
