/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Program provides information about Labradors Rocky, Buddy and Dilbert 
 * and Dogs Dog_1 and Dog_2.
 * This class contains program's main method. 
 * @author Sanchita Kanade
 */
public class Demo {

	/**
	 * This method have 3 generic parameters and 
	 * it returns the max highest item of the 3 parameters based on their sorting order.
	 * @param item1 is the generic parameter of the method
	 * @param item2 is the generic parameter of the method
	 * @param item3 is the generic parameter of the method
	 * @return method returns the max highest item from 3 parameters
	 */
	public static <T extends Comparable<T>> T maxHighest (T item1, T item2, T item3) {
		ArrayList<T> userVal = new ArrayList<T>();	
		userVal.add(item1);
		userVal.add(item2);
		userVal.add(item3);

		Collections.sort(userVal);

		return userVal.get(2);		
	}

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
	 * Creates three Strings, three Integers and three Labrador objects. 
	 *  and tests the maxHighest() method by passing objects to it.
	 * Calls printToFile() method to print three Labradors' data to the text file.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		// Test 1: Data for String  
		String str1 = "zzz";  
		String str2 = "aaa"; 
		String str3 = "mmm"; 

		// Test 2: Data for Integers
		Integer num1 = 44;    
		Integer num2 = 33;   
		Integer num3 = -1;   

		/* Test 3: Data for Labrador item1
		 * Creating Labrador object with object reference rocky 
		 * using default constructor and setting values with setter method 
		 */
		Labrador rocky = new Labrador();
		rocky.setName("Rocky");
		rocky.setHeight(16.5);
		rocky.setWeight(40);
		rocky.setAge(2);
		rocky.setColor("Black");
		rocky.setLifeSpan(12);

		/* Test 3: Data for Labrador item2
		 * Creating Labrador object with object reference buddy 
		 * using parameterized constructor 
		 */	
		Labrador buddy = new Labrador("Buddy", 2, 18, 55, "Golden",14);

		/* Test 3: Data for Labrador item3
		 * Creating Labrador object with object reference dilbert 
		 * using parameterized constructor 
		 */
		Labrador dilbert = new Labrador("Dilbert", 1, 14.5, 35, "Black", 15 );

		// Test 1: maxHighest method with Strings
		System.out.println("Items: " + str1 + " " + str2 + " " + str3);
		System.out.println("Max Highest Item: " + maxHighest(str1, str2, str3) + "\n");

		// Test 2: maxHighest method with Integers
		System.out.println("Items: " + num1 + " " + num2 + " " + num3);
		System.out.println("Max Highest Item: " + maxHighest(num1, num2, num3) + "\n");

		// Test 3: maxHighest method with Labrador objects
		System.out.println("Labradors: " + rocky.getName() + " " + buddy.getName() + " " + dilbert.getName());
		System.out.println("Labradors Ages: " + rocky.getAge() + " " + buddy.getAge() + " " + dilbert.getAge() + "\n");
		System.out.println("Max Highest Doggie(sorted by age and name): \n" + maxHighest(rocky, buddy, dilbert) + "\n");

		rocky.printToFile();
		buddy.printToFile();
		dilbert.printToFile();
	}
}

