/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program1)
 */
package edu.sdsu.cs.datastructures;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapPriQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    private PriorityQueue<E> priQueue;
    private Comparator<E> comparator;

    public HeapPriQueue(){
        priQueue = new PriorityQueue<>(Comparator.naturalOrder());
        comparator = Comparator.naturalOrder();
    }

    public HeapPriQueue(Comparator<E> comparator){
        priQueue = new PriorityQueue<>(comparator);
        this.comparator = comparator;
    }

    @Override
    public Comparator<E> comparator() {
        return comparator;
    }

    @Override
    public void enqueue(E item) {
        priQueue.offer(item);
    }

    @Override
    public E poll() {
        return priQueue.poll();
    }

    @Override
    public E peek() {
        return priQueue.peek();
    }

    @Override
    public int size() {
        return priQueue.size();
    }

    @Override
    public void clear() {
        priQueue.clear();
    }

    @Override
    public boolean isEmpty() {
        return priQueue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return priQueue.iterator();
    }

}
