/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents Labrador object's name, age, height, weight, color and Lifespan. 
 * Labrador class is derived from the Dog class 
 * and it implements Comparable and Printable Interface.
 * @author Sanchita Kanade
 *
 */
public class Labrador extends Dog implements Comparable<Labrador>, Printable {

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
	 * This method compares two Labrador objects based on age and name,
	 * and returns comparision result.
	 */
	@Override
	public int compareTo(Labrador otherLab) {
		int comparisonVal = 0;
		// Compare based on Age first.
		comparisonVal = getAge().compareTo(otherLab.getAge());

		// if both ages are same.
		if(comparisonVal == 0) {
			comparisonVal = getName().compareTo(otherLab.getName());
		}	

		return comparisonVal;	
	}

	/**
	 *  This method creats a new text file and prints data to the file.
	 */
	public void printToFile() {
		FileOutputStream newFile = null;
		PrintWriter printData = null;

		try {
			// File output stream 
			newFile = new FileOutputStream("file.txt",true);

			// Output stream
			printData = new PrintWriter(newFile);

			// File is open and valid, so we can now write to the file.
			printData.println("Doggie "+ getName()+ "'s data");
			printData.println("----------------------");
			printData.println(toString()+ "\n");
			printData.flush();

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
			System.out.println("file not found");
		}
		finally {
			try {
				// Closing file
				printData.close();
				newFile.close();
			}catch (IOException ioe) {
				System.out.println("Caught IOException: " + ioe.getMessage());
				System.out.println("There is an issue with closing the file");
			}
		}

	}

	/**
	 * This method overrides Dog's display method
	 * prints out the values of all instance variables of the Labrador object
	 */

	public void display() {
		super.display();		
		System.out.printf("%-8s :  %d %s\n", "Lifespan" ,getLifeSpan(), "years");
	}

	/**
	 * This method overrides Object's toString method and
	 * returns a String representation of Labrador Object.
	 */

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
