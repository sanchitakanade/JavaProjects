/*
 * Student name: Sanchita Kanade
 * Class: CS108 Java Programming
 * 
 */

/**
 * Turkey class
 * This class represents Turkey object's type and weight. 
 * @author Sanchita Kanade
 */
public class Turkey {

	private String type;
	private int weight;   //weight rounded up, in lbs.

	public Turkey(String type, int weight) {
		super();
		this.type = type;
		this.weight = weight;
	}

	/**
	 * Returns the type.
	 * @return the type represents Turkey's type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type field.
	 * @param type represents the type of Turkey.  
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the weight.
	 * @return weight represents the weight of Turkey.
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets the weight field.
	 * @param weight represents the weight of Turkey.
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}	
}
