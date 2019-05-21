
/*
 * Name: Sanchita Kanade
 * Class: CS108_Java Programming
 */

import java.util.Scanner;
import java.util.Random;

/**
 * Program generates SuperLotto lottery tickets as per user's requirement.
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

		while (i < totalNumInLottTicket) {
			if (i < (totalNumInLottTicket - 1)) {
				int newNum = (randGen.nextInt(maxRangeFirstFiveNum) + initRangeFirstFiveNum);
				isNumDuplicate = isDuplicate(newNum, lotteryNumbers, i);
				if (!isNumDuplicate) {
					lotteryNumbers[i] = newNum;
					lottoNumString = lottoNumString + lotteryNumbers[i] + " ";
					i++;
				}
				continue;
			}
			if (i == (totalNumInLottTicket - 1)) {
				lotteryNumbers[i] = (randGen.nextInt(maxRangeMegaNum) + initRangeMegaNum);
				lottoNumString = lottoNumString + ("" + "MEGA " + "(" + lotteryNumbers[i] + ")");
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
	 * Asks for how many lottery tickets user wants and calls generateNumbers()
	 * method to print out lottery numbers to the screen.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		// Prompts user for number of Lotto tickets require.
		System.out.println("How many Super Lotto tickets do you want?");
		
		// Number of Lotto tickets user wants.
		int numOfTickets = scnr.nextInt(); 

		// calls generateNumbers method and prints lottery numbers.
		for (int i = 0; i < numOfTickets; i++) {

			System.out.println(generateNumbers());
		}
		return;
	}

}
