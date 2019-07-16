/*
 * Name: Sanchita Kanade
 * class: CS310
 */
public class App {
	
	//recursive method
	private int binarySearch(int[] arr, int target, int low, int high) {
		if (low <= high) {
			// int mid = low + ((high - low)/2);
			int mid = low + ((high - low) >> 1);
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] > target) {
				return binarySearch(arr, target, low, mid - 1);
			}
			return binarySearch(arr, target, mid + 1, high);
		}
		return -1;
	}

	// binary search implementation without recursion
	private int binarySearch1(int[] arr, int  target, int low, int high) {

		while (low <= high) {
			int mid = low + ((high - low)>>1);

			if(arr[mid] == target){
				return mid;
			}
			if(arr[mid] > target) {
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return -1;
	}

	public static void main( String[] args ) {
		int result;
		int[] arr = {1, 3, 4, 5};
		App a = new App();

		/* First integer is a value to seach from arr, second and third parameters are
		 * first and last indices of arr
		 */
		result = a.binarySearch(arr, 5,0,3); 
		System.out.println("using recursive method element is at index position: arr["+ result+ "]\n");

		/* First integer is a value to seach from arr, second and third parameters are
		 * first and last indices of arr
		 */
		result = a.binarySearch1(arr, 5,0,3); 
		System.out.println("element is at index position: arr["+ result+ "]\n");
	}
}
