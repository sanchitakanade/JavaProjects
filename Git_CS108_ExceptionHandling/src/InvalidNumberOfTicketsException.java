/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */
/**
 * Custom Exception for lottery tickets less than or equal to 0. 
 * @author Sanchita Kanade
 *
 */
@SuppressWarnings("serial")
public class InvalidNumberOfTicketsException extends Exception{
	// Default Constructor
	public InvalidNumberOfTicketsException() {
		
	}
	// Constructor that accepts a message
	public InvalidNumberOfTicketsException(String message) {
		super(message);
	}
}
