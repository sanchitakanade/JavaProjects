/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program1)
 */
package edu.sdsu.cs.datastructures;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayPriQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    private ArrayList<E> arrayList;
    private Comparator<E> comparator;

    public ArrayPriQueue() {
        arrayList = new ArrayList<>();
        comparator = Comparator.naturalOrder();
    }

    public  ArrayPriQueue(Comparator<E> comparator){
        arrayList = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public Comparator<E> comparator() {
        return comparator;
    }

    @Override
    public void enqueue(E item) {
        if (arrayList.isEmpty()) {
            arrayList.add(item);
        }
        else {
            int position = binarySearch(arrayList, item, 0, arrayList.size() - 1);
            arrayList.add(position,item);
        }
    }

    @Override
    public E poll() {
        return arrayList.isEmpty() ? null : arrayList.remove(0);
    }

    @Override
    public E peek() {
        return arrayList.isEmpty() ? null : arrayList.get(0);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public void clear() {
        arrayList.clear();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return arrayList.iterator();
    }


    private int binarySearch(ArrayList<E> arrList, E valToInsert, int low, int high) {

        while (low <= high) {
            int mid = low + ((high - low)>>1);
            int comparisonResult = comparator.compare(arrList.get(mid),valToInsert);

            if(comparisonResult == 0) {
                int nextVal = mid + 1;
                while(nextVal < arrList.size() && arrList.get(nextVal) == valToInsert) {
                    nextVal++;
                }
                return nextVal;
            }
            if(comparisonResult > 0) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }
}

