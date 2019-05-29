/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program1)
 */
package edu.sdsu.cs.datastructures;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class UnorderedPriQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    private ArrayList<E> arrayList;
    private Comparator<E> comparator;

    public UnorderedPriQueue() {
        arrayList = new ArrayList<>();
        comparator = Comparator.naturalOrder();
    }

    public UnorderedPriQueue(Comparator<E> comparator) {
        arrayList = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public Comparator<E> comparator() {
        return comparator;
    }

    //Appends the element at the end of the list.
    @Override
    public void enqueue(E item) {
        arrayList.add(item);
    }

    //This method always remove minimum value from the Priority Queue.
    @Override
    public E poll() {
        return arrayList.isEmpty() ? null : arrayList.remove(findElementWithLowestPriority());
    }

    @Override
    public E peek() {
        return arrayList.isEmpty() ? null : arrayList.get(findElementWithLowestPriority());
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

    //This method finds lowest value by comparing all elements with each other.
    private int findElementWithLowestPriority() {
        int indexHavingMinimumValue = 0;
        E lowestVal = arrayList.get(0);
        for(int index = 1; index < arrayList.size(); index++) {
            if((comparator.compare(lowestVal,arrayList.get(index))) > 0){
                lowestVal = arrayList.get(index);
                indexHavingMinimumValue = index;
            }
        }
        return indexHavingMinimumValue;
    }
}
