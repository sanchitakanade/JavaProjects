/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

/**
 * This class represents Labrador object's name, age, height, weight, color and Lifespan. 
 * Labrador class is derived from the Dog class.
 * @author Sanchita Kanade
 *
 */
public class Labrador extends Dog {

	private int lifeSpan;

	/**
	 * Sets the lifeSpan field.
	 * @param lifeSpan represents Labrador's lifeSpan in years.
	 */
	public void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	/**
	 * Returns the Labrador's lifeSpan.
	 * @return an integer value represents the lifeSpan in years.
	 */
	public int getLifeSpan() {
		return lifeSpan;
	}

	/**
	 * This method overrides Dog's display method
	 * prints out the values of all instance variables of the Labrador object
	 */
	@Override
	public void display() {
		super.display();		
		System.out.printf("%-8s :  %d %s\n", "Lifespan" ,getLifeSpan(), "years");
	}

	/**
	 * This method overrides Object's toString method and
	 * returns a String representation of Labrador Object.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nLifespan : " + lifeSpan + " years";
	}

	/**
	 * This method overrides Object's equals method.
	 * Compares a Labrador object to another Labrador object and returns true 
	 * if two objects have equal data/contents otherwise, the equals() method returns false. 
	 */
	@Override
	public boolean equals(Object lab) {
		if (lab instanceof Labrador) {
			if (this.getAge() == ((Labrador)lab).getAge() 
					&& this.lifeSpan == ((Labrador)lab).lifeSpan
					&& this.getColor() == ((Labrador)lab).getColor()
					&& this.getHeight() == ((Labrador)lab).getHeight()
					&& this.getWeight() == ((Labrador)lab).getWeight())
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Default constructor initializing all fields to their default values.
	 */
	public Labrador() {
		super();
		lifeSpan = 8;
	}

	/**
	 * Parameterized constructor initializing all fields to different values
	 * given by the user.
	 * 
	 * @param name represents Labrador's name.
	 * @param age represents Labrador's age in years.
	 * @param height represents Labrador's height in inches.
	 * @param weight represents Labrador's weight in pounds.
	 * @param color represents Labrador's color.
	 * @param lifeSpan represents Labrador's life span in years.
	 */
	public Labrador(String name, int age, double height, double weight, String color, int lifeSpan) {
		super(name, age, height, weight, color);
		this.lifeSpan = lifeSpan;
	}
}
