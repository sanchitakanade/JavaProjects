/*
 * Student name: Sanchita Kanade
 * Class: CS108 Java Programming
 */

import java.util.ArrayList;

/**
 * Thanksgiving class
 * This Class contains quicksort(), binarySearch(), and a recursive method eatTurkey(),
 * to sort Turkeys, search a specific turkey and eat that Turkey.
 * @author Sanchita Kanade
 */
public class Thanksgiving {

	/**
	 * This method sorts the ArrayList of Turkey objects by weight (lowest to highest),
	 * using Quick sort algorithm. 
	 * I choose this sorting algorithm, 
	 * because runtime for both Selection sort and Insertion sort is O(n2)[Big-O of n squared], 
	 * on the other hand runtime for Quick sort algorith is O(n log n).
	 * Hence, Quick sort have faster execution time than Selection and Insertion sort.
	 * Moreover, in this case there is no unequal partitioning at every level during sorting, 
	 * so it is not the worst case for Quick sort algorithm and runtime for Quick sort algorith is O(n log n).
	 * Merge sort algorithm's runtime is also O(n log n), but it requires additional memory 
	 * to store elements in temporary array, hence Quick sort algorithm is efficient in this case.
	 * 
	 * I write this code with the help of learn.zybooks.com and passed ArrayList of turkey objects 
	 * to partition and quicksort methods as a parameter.
	 * 
	 * @param turkeys represents ArrayList of turkeys.
	 * @param i represents the lowest index of an ArrayList.
	 * @param k represents the highest index of an ArrayList.
	 */
	public static void quicksort(ArrayList<Turkey> turkeys, int i, int k) {
		int j = 0;

		/* Base case: If there are 1 or zero entries to sort, 
		 * partition is already sorted
		 */
		if (i >= k) {
			return;
		}

		/* Partition the data within the ArrayList. Value j returned
		 * from partitioning is location of last item in low partition.
		 */
		j = partition(turkeys, i, k);

		/* Recursively sort low partition (i to j) and
		 * high partition (j + 1 to k)
		 */
		quicksort(turkeys, i, j);
		quicksort(turkeys, j + 1, k);

		return;
	}

	/**
	 * This method partitions the input into low and high parts.
	 * @param turkeys represents ArrayList of turkeys.
	 * @param i represents the lowest index of an ArrayList.
	 * @param k represents the highest index of an ArrayList.
	 * @return h represents the index of the last element in the low partition.
	 */
	public static int partition(ArrayList<Turkey> turkeys, int i, int k) {
		int l = 0;
		int h = 0;
		int midpoint = 0;
		int pivot = 0;
		Turkey temp;
		boolean done = false;

		/* Pick middle element as pivot */
		midpoint = i + (k - i) / 2;
		pivot = turkeys.get(midpoint).getWeight();

		l = i;
		h = k;

		while (!done) {
			while (turkeys.get(l).getWeight() < pivot) {
				++l;
			}
			while (pivot < turkeys.get(h).getWeight()) {
				--h;
			}

			/* If there are zero or one items remaining,
			 * all numbers are partitioned. Return h. 
			 */
			if (l >= h) {
				done = true;
			} else {

				/* Swap elements at index l and h in the Arraylist of Turkey objects,
				 * update l and h
				 */
				temp = turkeys.get(l);
				turkeys.set(l,turkeys.get(h));
				turkeys.set(h,temp);
				++l;
				--h;
			}
		}
		return h;
	}

	/**
	 * This method searchs an ArrayList of Turkey objects, 
	 * and returns the index of the Turkey by a specified weight.
	 * @param key represents weight of Turkey.
	 * @param turkeys represents ArrayList of turkeys.
	 * @return an index of the Turkey.
	 * 
	 * refered www.coursera.org and zybooks to write this code.
	 */
	public static int binarySearch(int key, ArrayList<Turkey> turkeys) {
		int low = 0;
		int high = turkeys.size() - 1;
		int mid = 0;

		while(low <= high) {
			mid = low + ((high-low)/2) ;
			if(key == (turkeys.get(mid).getWeight())) {
				return mid;
			}
			else {
				if(key < (turkeys.get(mid).getWeight())) {
					high = mid - 1; 
				}
				else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	/**
	 * This method recursively eats a turkey,
	 * by subtracting 1 lb of turkey for each recursive call.
	 * @param t represents Turkey object.
	 */
	public static void eatTurkey(Turkey t) {
		int weight = t.getWeight();

		if(t.getWeight() == 0) {
			System.out.println("Done");
			return;
		}	
		System.out.println("Gobble Gobble, there are " + weight + "  lbs. of turkey remaining");
		weight = weight - 1;
		t.setWeight(weight);
		eatTurkey(t);		
	}

	/**
	 * This method creates an ArrayList of Turkey objects and
	 * calls quicksort(), binarySearch() and eatTurkey() methods.
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		int index;
		ArrayList<Turkey> turkeys = new ArrayList<Turkey>();

		turkeys.add(new Turkey("Butterball", 20));
		turkeys.add(new Turkey("Jenni-O", 12));
		turkeys.add(new Turkey("Foster Farms", 24));
		turkeys.add(new Turkey("Honeysuckle", 17));
		turkeys.add(new Turkey("Trader Joes", 32));
		turkeys.add(new Turkey("Norbest", 10));
		turkeys.add(new Turkey("Vons O Organics", 38));

		// calling quicksort() method to sort the ArrayList of Turkey objects by weight.
		quicksort(turkeys, 0, (turkeys.size() - 1));
	
		// calling binarySearch() method to get an index of Turkey having weight 32 lbs.
		index = binarySearch(32, turkeys);

		if (index >= 0) {

			//calling eatTurkey() method, which recursively eats a turkey.
			eatTurkey(turkeys.get(index));
		}
		else {
			System.out.println("Turkey not found");
		}
	}
}





