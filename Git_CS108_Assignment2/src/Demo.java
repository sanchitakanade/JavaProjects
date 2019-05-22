/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming, fall 2017
 */

/**
 * Program provides information about dogs Dilbert and Tommy.
 * This class contains the program's main method. 
 * @author Sanchita Kanade
 */

public class Demo {
	/**
	 * Creates two new Dog objects. Uses default constructor to initialize Dog
	 * state, that have object reference variable dilbert. Invokes setter
	 * (mutator) methods to assign values to the Dog object having reference
	 * variable dilbert. 
	 * Uses parameterized constructor to create another Dog object with reference 
	 * variable tommy. 
	 * Calls display method to print out data of two Dog objects.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		/*
		 * Creating Dog object with object reference dilbert 
		 * using default constructor and setting values with setter method.
		 */
		Dog dilbert = new Dog();
		dilbert.setName("Dilbert");
		dilbert.setAge(2);
		dilbert.setHeight(17.5);
		dilbert.setWeight(45.5);
		dilbert.setColor("golden");
		System.out.println("Doggie Dilbert's data ");
		System.out.printf("----------------------\n");
		dilbert.display();

		/*
		 * Creating Dog object with object reference tommy 
		 * using parameterized constructor.
		 */
		Dog tommy = new Dog("Tommy",3, 15, 50, "black");
		System.out.println("\n" + "Doggie Tommy's data");
		System.out.printf("----------------------\n");
		tommy.display();
	}
}
