/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

/**
 * This class represents node objects for Single Linked List
 * @author Sanchita Kanade
 */
public class Node {

	Food foodItem;
	Node next;

	/**
	 * Default constructor initializing all fields to their default values.
	 */
	public Node() {
		this(null,null);
	}

	/**
	 * Parameterized constructor initializing all fields to different values given by the programmer.
	 * @param foodItem represents a food object.
	 */
	public Node(Food foodItem) {
		this(foodItem,null);
	}

	/**
	 * Parameterized constructor initializing all fields to different values given by the programmer.
	 * @param foodItem represents a food object.
	 * @param next represents the reference for next node in the Single Linked List
	 */
	public Node(Food foodItem, Node next) {
		this.foodItem = foodItem;
		this.next = next;
	}

}
