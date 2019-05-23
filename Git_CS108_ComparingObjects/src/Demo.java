/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

/**
 * Program provides information about Labradors Rocky, Buddy and Dilbert
 * and checks whether they are equal or not.
 * This class contains the program's main method. 
 * @author Sanchita Kanade
 */
public class Demo {
	
	/**
	 * Creates three new Labrador objects. Uses default constructor to initialize Labrador
	 * state, that have object reference variable rocky. Invokes setter
	 * (mutator) methods to assign values to the Labrador object having reference
	 * variable rocky. 
	 * Uses parameterized constructor to create other Labrador objects with reference 
	 * variable buddy and dilbert. 
	 * Calls toString method to print out data of three Labrador objects and
	 * checks whether these objects are equal or not.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		
		/*
		 * Creating Labrador object with object reference rocky 
		 * using default constructor and setting values with setter method and printing 
		 * values of all instance variables by calling toString method.
		 */
		Labrador rocky = new Labrador();
		rocky.setName("Rocky");
		rocky.setHeight(16.5);
		rocky.setWeight(40);
		rocky.setAge(2);
		rocky.setColor("Black");
		rocky.setLifeSpan(12);
		System.out.println("Doggie Rocky's data ");
		System.out.printf("----------------------\n");
		//Using display method to print values
		//rocky.display();
		
		//Using overriden toString() method to print values
		System.out.println(rocky);

		/*
		 * Creating Labrador object with object reference buddy 
		 * using parameterized constructor and printing values of all instance 
		 * variables by calling toString method.
		 */	
		Labrador buddy = new Labrador("Buddy", 4, 18, 55, "Golden",14);
		System.out.println("\n" + "Doggie Buddy's data");
		System.out.printf("----------------------\n");
		//Using display method to print values
		//buddy.display();
		
		//Using overriden toString() method to print values
		System.out.println(buddy);

		/*
		 * Creating Labrador object with object reference dilbert 
		 * using parameterized constructor and printing values of all instance 
		 * variables by calling toString method.
		 * 
		 */
		Labrador dilbert = new Labrador("Dilbert", 2, 16.5, 40, "Black", 12 );
		System.out.println("\n" + "Doggie Dilbert's data");
		System.out.printf("----------------------\n");
		
		//Using display method to print values
		//dilbert.display();
		
		//Using overriden toString() method to print values
		System.out.println(dilbert);

		/*
		 * Checks whether Rocky & Buddy are equal objects or not by calling equals method.
		 */
		if (rocky.equals(buddy)){
			System.out.println("\nequals() returns: Rocky and Buddy are same");
		}
		else {
			System.out.println("\nequals() returns: Rocky and Buddy are NOT same");
		}

		/*
		 * Checks whether Rocky & Dilbert are equal objects or not by calling equals method.
		 */
		if (rocky.equals(dilbert)){
			System.out.println("\nequals() returns: Rocky and Dilbert are same");
		}
		else {
			System.out.println("\nequals() returns: Rocky and Dilbert are NOT same");
		}

	}
}
