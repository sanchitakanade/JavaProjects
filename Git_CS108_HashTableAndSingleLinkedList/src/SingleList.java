/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

/**
 * This class contains head(Node) and tail(Node) fields for creating a Single Linked List
 * also contains add(Food), remove(Food) and search(Food) methods 
 * to add a food item, to remove a food item and to search for a particular food item into the Single Linked List
 * @author Sanchita Kanade
 */
public class SingleList {

	Node head;
	Node tail;

	/**
	 * This method adds a new node having data Food object into the Single Linked List
	 * @param foodItem represents a food object.
	 */
	public void add(Food foodItem) {
		if(head == null) {
			Node newNode = new Node(foodItem,null);// Node newNode = new Node(val);
			//newNode.key = key;// no need of this line
			head = newNode;
			tail = newNode;
			newNode.next = null;
		}
		else {
			Node newNode = new Node(foodItem);
			Node temp = tail;
			temp.next = newNode;
			tail = newNode;
		}
	}

	/**
	 * This method removes a Node with particular Food item field from Single Linked List
	 * @param foodItem represents a food object.
	 */
	public void remove(Food foodItem) {
		String name = foodItem.getName();
		int calories = foodItem.getCalories();
		Node temp = head;
		while(temp != null){
			Node last = temp;
			if(temp.foodItem.getName().equals(name) && temp.foodItem.getCalories() == calories){
				if(head == temp) {
					head = head.next;
					temp = head;
				}
				else if (temp.next != null){
					last.next = temp.next;
				}
				else temp.next = null;
			}
			else temp = temp.next;
		}
	}

	/**
	 * This method search for a Node having particular Food item field into the Single Linked List 
	 * and returns it if found. 
	 * @param foodItem represents a food object.
	 * @return returns a Node having particular Food item field if found.
	 */
	public Node search(Food foodItem) {
		String name = foodItem.getName();
		int calories = foodItem.getCalories();

		Node temp = head;

		while(temp != null) 
			if(temp.foodItem.getName().equals(name) && temp.foodItem.getCalories() == calories)
				return temp;
			else {
				temp = temp.next;
			}
		return null;
	}

	public void print() {
		Node tempNode = head;
		while(tempNode != null){
			System.out.println(tempNode.foodItem.getName() + " " +tempNode.foodItem.getCalories());
			tempNode= tempNode.next;
		}

	}

}
