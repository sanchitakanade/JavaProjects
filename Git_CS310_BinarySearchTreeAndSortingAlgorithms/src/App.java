/*
 * Name: Sanchita Kanade
 * Class: CS310
 */
import java.util.List;

public class App 
{
    public static int[] insertionSort(int[] input) {
        int temp;
        for(int i = 1; i < input.length; i++) {
            int j = i-1;
            temp = input[i];
            while(j >= 0 && input[j]> temp) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = temp;
        }
        return input;
    }

    public static int[] selectionSort(int[] input) {
        for(int i = input.length-1 ; i >= 0; i--) {
            int largest = input[0];
            int maxIndex = 0;
            int j = 0;
            while(j <= i ) {
                if(input[j] > largest) {
                    largest = input[j];
                    maxIndex = j;
                }
                j++;
            }
            input[maxIndex] = input[i];
            input[i] = largest;
        }
        return input;
}
    public static void main( String[] args ) {
        int[] a ={54,8,40,-23,9,12,13,99,0};
       selectionSort(a);
       System.out.println("Array elements after Selection sort:");
        for(int b: a) {
            System.out.println(b);
        }
        
        int[] b ={54,8,40,-23,9,12,13,99,0};
        insertionSort(b);
        System.out.println("\nArray elements after Insertion sort:");
        for(int c: b) {
            System.out.println(c);
        }

        BST tree = new BST();
        tree.add(40);
        tree.add(20);
        tree.add(50);
        tree.add(10);
        tree.add(25);
        System.out.println("\n\nBinary Search Tree:");
        System.out.println("height of element 40:"+ tree.height(40));
        
        // printing all elements of tree by inorder traversal
        List<Integer> list = tree.inOrder();
        System.out.println("Inorder traversal of the tree:");
        for(int e: list) {
            System.out.println(e);
        }      
    }
}
