/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program1)
 */
package edu.sdsu.cs;
import edu.sdsu.cs.datastructures.ArrayPriQueue;
import edu.sdsu.cs.datastructures.HeapPriQueue;
import edu.sdsu.cs.datastructures.IPriorityQueue;
import edu.sdsu.cs.datastructures.UnorderedPriQueue;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    private static Random randomNum = new Random();
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static int operationCount = 0, queueNameId = 0;

    private static void testReverseOrderedInput(IPriorityQueue<Integer> queue, int size, int operationId) {
        try{
            FileWriter writer = new FileWriter("output.csv", true);

            if(queueNameId > 0 && operationCount == 0) {
                if(queueNameId == 1) writer.write("Array Based Priority Queue"+ "\n");
                if(queueNameId == 2) writer.write("\nUnordered Priority Queue\n");
                if(queueNameId == 3) writer.write("\nHeap Based Priority Queue\n");
            }
            if(operationCount == 0 && operationId == 1) {
                writer.write("enqueue() "+"\n");
                writer.write("input size" + "," + "time in milliseconds" + "\n");
                operationCount = 1;
            }

            for(int i = 0; i < size; i++) {
                arrayList.add(randomNum.nextInt(10000) + 1);
            }
            arrayList.sort(Collections.reverseOrder());

            long startTime = System.nanoTime();
            for(int integer : arrayList) {
                queue.enqueue(integer);
            }
            long requiredTime = (System.nanoTime() - startTime)/1000000;
            if(operationId == 1) {
                System.out.println("Total time required for enqueue(): " + requiredTime  +" milliseconds\n");
                writer.write(size + "," + requiredTime + "\n");
                writer.close();
            }

            if(operationCount == 1 && operationId == 2) {
                writer.write(" " + "\n");
                writer.write("poll() "+"\n");
                writer.write("input size" + "," + "time in microseconds" + "\n");
                operationCount = 2;
            }

            startTime = System.nanoTime();
            queue.poll();
            requiredTime = (System.nanoTime() - startTime)/1000;
            if(operationId == 2) {
                System.out.println("Total time required for poll(): " + requiredTime +" microsecond\n");
                writer.write(size + "," + requiredTime + "\n");
                writer.close();
            }
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
        queue.clear();
        arrayList.clear();
    }

    private static void testSortedInput(IPriorityQueue<Integer> queue1, int size) {
        try{
            FileWriter writer = new FileWriter("output.csv", true);

            if(queueNameId > 0 && operationCount == 0) {
                if(queueNameId == 2) writer.write("\nUnordered Priority Queue\n");
            }
            if(operationCount == 0) {
                writer.write("enqueue() "+"\n");
                writer.write("input size" + "," + "time in milliseconds" + "\n");
                operationCount = 1;
            }
            for(int i = 0; i < size; i++)
                arrayList.add(randomNum.nextInt(1000000)+1);
            arrayList.sort(null);

            long startTime = System.nanoTime();
            for(int integer : arrayList)
                queue1.enqueue(integer);
            long requiredTime = (System.nanoTime() - startTime)/1000000;
            System.out.println("Total time required for enqueue(): " + requiredTime + " milliseconds\n");
            writer.write(size + "," + requiredTime + "\n");
            writer.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        queue1.clear();
        arrayList.clear();
    }

    public static void main(String[] args) {

        ArrayPriQueue<Integer> queue1 = new ArrayPriQueue<>();
        System.out.println("Array based Priority Queue:\n");
        queueNameId = 1;
        for(int inputSize = 10000; inputSize < 161000; inputSize *= 2) {
            System.out.println("Input size N: " + inputSize);
            //operationId for enqueue() operation is 1
            testReverseOrderedInput(queue1,inputSize,1);
        }
        for(int inputSize = 10000; inputSize < 161000; inputSize *= 2) {
            System.out.println("Input size N: " + inputSize);
            //operationId for poll() operation is 2
            testReverseOrderedInput(queue1,inputSize,2);
        }

        UnorderedPriQueue<Integer> queue2 = new UnorderedPriQueue<>();
        System.out.println("Unordered Priority Queue:\n");
        operationCount = 0; queueNameId = 2;
        for(int inputSize = 90000; inputSize < 10000000; inputSize *= 2) {
            System.out.println("Input size N: " + inputSize);
            //testing enqueue() operation
            testSortedInput(queue2,inputSize);
        }
        for(int inputSize = 90000; inputSize < 10000000; inputSize *= 2) {
            System.out.println("Input size N: " + inputSize);
            //operationId for poll() operation is 2
            testReverseOrderedInput(queue2,inputSize,2);
        }

        HeapPriQueue<Integer> queue3 = new HeapPriQueue<>();
        System.out.println("Heap Based Priority Queue:\n");
        queueNameId = 3; operationCount = 0;
        for(int inputSize = 100000; inputSize < 10000000; inputSize *= 2) {
            System.out.println("Input size N: " + inputSize);
            //operationId for enqueue() operation is 1
            testReverseOrderedInput(queue3,inputSize,1);
        }

        for(int inputSize = 100000; inputSize < 10000000; inputSize *= 2) {
            System.out.println("Input size N: " + inputSize);
            //operationId for poll() operation is 2
            testReverseOrderedInput(queue3,inputSize,2);
        }

        System.out.println("Program complete");
    }
}

