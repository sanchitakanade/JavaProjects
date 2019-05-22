
/*
 * Name: Sanchita Kanade
 * Class: CS108 Java Programming
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.FileWriter; 
import java.io.IOException;

/**
 * Program generates SuperLotto lottery tickets as per user's requirement and 
 * prints those tickets to the lottery.txt file.
 * 
 * @author Sanchita Kanade
 */
public class SuperLottoPlus {
	/**
	 * Returns a String containing 6 random SuperLotto lottery numbers. 
	 * The first 5 numbers are random numbers from the range 1 to 47, and the 6th
	 * number (the MEGA) is from 1 to 27. There are no duplicate numbers in the
	 * first 5 numbers of a string.
	 * 
	 * @return a String with SuperLotto lottery number.
	 */
	public static String generateNumbers() {

		//Resulting string with lottery number.
		String lottoNumString = "";

		/*
		 * initRangeFirstFiveNum is initial range for first five numbers.
		 * maxRangeFirstFiveNum is maximum range for first five numbers.
		 */
		int initRangeFirstFiveNum = 1;
		int maxRangeFirstFiveNum = 47;

		/*
		 * initRangeMegaNum is initial range for the MEGA number.
		 * maxRangeMegaNum is maximum range for the MEGA number.
		 */
		int initRangeMegaNum = 1;
		int maxRangeMegaNum = 27;

		// Represents total numbers in one lottery ticket.
		int totalNumInLottTicket = 6;

		Random randGen = new Random();
		int[] lotteryNumbers = new int[totalNumInLottTicket];

		boolean isNumDuplicate = false;
		int i = 0;

		while (i < lotteryNumbers.length) {
			if (i < (lotteryNumbers.length - 1)) {
				int newNum = (randGen.nextInt(maxRangeFirstFiveNum) + initRangeFirstFiveNum);
				isNumDuplicate = isDuplicate(newNum, lotteryNumbers, i);
				if (!isNumDuplicate) {
					lotteryNumbers[i] = newNum;
					lottoNumString += lotteryNumbers[i] + " ";
					i++;
				}
				continue;
			}
			if (i == (lotteryNumbers.length - 1)) {
				lotteryNumbers[i] = (randGen.nextInt(maxRangeMegaNum) + initRangeMegaNum);
				lottoNumString += "(MEGA: " + lotteryNumbers[i] + ")";
				i++;
			}
		}
		return (lottoNumString);
	}	
	/** 
	 * Checks whether the newly generated random number(newNum) is duplicate or
	 * not before adding it into the lotteryNumbers array.
	 * 
	 * @param newNum the newly generated random number.
	 * @param lotteryNumbers the array reference variable for lotteryNumbers array.
	 * @param currIndexFilledArray is array index for lotteryNumbers array.
	 * @return a boolean value is the answer for whether newly
	 *         generated random number is duplicate or not.
	 */
	public static boolean isDuplicate(int newNum, int[] lotteryNumbers, int currIndexFilledArray) {
		// Checks if newNum exists in filled array.
		for (int j = 0; j < currIndexFilledArray; ++j) {
			if (lotteryNumbers[j] == newNum) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Method appends a string in a file lottery.txt using write() and closes a FileWriter. 
	 * Throws IOException if write() operation fails or close() operation fails or file not created.
	 * 
	 * @param lottoNumString represents a String with SuperLotto lottery number.
	 * @throws IOException Method throws exception if there is an issue with creation of a lottery.txt file 
	 * or writing to the file or closing the file.
	 */
	public static  void printTicket(String lottoNumString) throws IOException {
		/* File Writer to write into file which may throw exception
		 * write() may throw IOException if fails
		 * close() may throw IOException if fails
		 */
		FileWriter writer = new FileWriter("lottery.txt", true);
		writer.write(lottoNumString +"\n");
		writer.close();
	}

	/**
	 * Method asks for how many lottery tickets user wants and calls generateNumbers()method
	 * numberOfTickets times And prints out lottery numbers to lottery.txt file 
	 * by calling printTicket().
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		int numOfTickets = 0;

		// Prompts user for number of Lotto tickets require.
		System.out.println("How many Super Lotto tickets do you want?");

		try {
			// Number of Lotto tickets user wants.
			numOfTickets = scnr.nextInt(); 

			if (numOfTickets <= 0){
				throw new InvalidNumberOfTicketsException("Please enter a positive integer");
			}
			// calls generateNumbers method and printTicket method to print lottery numbers to lottery.txt file.
			for (int i = 0; i < numOfTickets; i++) {   
				printTicket(generateNumbers());
			}
			System.out.println("Your lottery numbers have been written to the file lottery.txt");

		}
		catch(InputMismatchException ex){
			System.out.println("Caught InputMismatchException: Please enter an integer value");  
		}
		catch(InvalidNumberOfTicketsException excpt){
			System.out.println("Caught InvalidNumberOfTicketsException: " + excpt.getMessage());
		} 
		catch (IOException ioe) {
			System.out.println("Caught IOException: " + ioe.getMessage());
			System.out.println("There is an issue with creation of a lottery.txt file or writing to the file or closing the file");
		}

	}

}
