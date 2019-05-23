/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

import java.util.ArrayList;

/**
 * Program provides information about Labradors Rocky, Buddy and Dilbert 
 * and Dogs Dog_1 and Dog_2.
 * This class contains program's main method. 
 * @author Sanchita Kanade
 */
public class Demo {

	/**
	 * This method takes an ArrayList of Dog class as a parameter.
	 * Calls the toString method on each object in the ArrayList and  
	 * prints out the values of all instance variables of the Dog and Labrador object
	 * 
	 * @param dogs represesnts ArrayList of pets.
	 */
	public static void displayAll(ArrayList<Dog> dogs) {
		// Using enhanced for loop
		for(Dog dog : dogs) {
			System.out.println("\n" + dog.toString());
		}
	}

	/**
	 * Creates three Labrador objects and two Dog objects. 
	 * Uses default constructor to create a Labrador objects with reference 
	 * variable rocky. 
	 * Uses parameterized constructor to create other Labrador objects with reference 
	 * variables buddy and dilbert.
	 * Uses parameterized constructor to create Dog objects with reference 
	 * variables dog1 and dog2
	 * 
	 * Creates an ArrayList containing objects of both Dog class(baseclass) and Labrador class(subclass).
	 * Calls displayAll method, passing ArrayList of objects.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		/*
		 * Creating Labrador object with object reference rocky 
		 * using default constructor and setting values with setter method 
		 */
		Labrador rocky = new Labrador();
		rocky.setName("Rocky (Labrador)");
		rocky.setHeight(16.5);
		rocky.setWeight(40);
		rocky.setAge(2);
		rocky.setColor("Black");
		rocky.setLifeSpan(12);

		/*
		 * Creating Labrador object with object reference buddy 
		 * using parameterized constructor 
		 */	
		Labrador buddy = new Labrador("Buddy (Labrador)", 4, 18, 55, "Golden",14);

		/*
		 * Creating Labrador object with object reference dilbert 
		 * using parameterized constructor 
		 */
		Labrador dilbert = new Labrador("Dilbert (Labrador)", 1, 14.5, 35, "Black", 15 );

		/*
		 * Creating Dog object with object reference dog1
		 * using parameterized constructor 
		 */
		Dog dog1 = new Dog("Dog_1", 3, 15, 45, "Brown");

		/*
		 * Creating Dog object with object reference dog2
		 * using parameterized constructor 
		 */
		Dog dog2 = new Dog("Dog_2", 5, 17.5, 50, "white");

		//Creating an ArrayList containing objects of both base class and subclass. 
		ArrayList<Dog> pets = new ArrayList<Dog>();
		pets.add(dilbert);
		pets.add(buddy);
		pets.add(rocky);
		pets.add(dog1);
		pets.add(dog2);

		//Invokes displayAll method and passing ArrayList of objects 
		displayAll(pets);

	}

}
