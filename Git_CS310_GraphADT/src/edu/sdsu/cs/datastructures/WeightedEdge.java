/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program2)
 */
package edu.sdsu.cs.datastructures;

public class WeightedEdge<E> implements IEdge<E> {
    private IVertex start;
    private IVertex destination;
    private E weight;

    public WeightedEdge(IVertex start, IVertex destination, E weight) {
        this.start = start;
        this.destination = destination;
        this.weight = weight;
    }

    public String toString() {
        return "(" + start + ", " + destination + ", " + weight +")";
    }

    @Override
    public E getWeightOnEdge() {
        return weight;
    }

    @Override
    public IVertex getDestinationVertex() {
        return destination;
    }

}
