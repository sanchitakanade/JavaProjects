/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program2)
 */
package edu.sdsu.cs.datastructures;

public interface IEdge<E> {

    /**
     *Provides weight or cost on a edge between two vertices
     * @return an integer which represents a value of weight on the edge
     */
    E getWeightOnEdge();

    /**
     *Provides the value of a destination vertex
     * @return an object of GraphVertex represents last vertex connected to the edge
     */
    IVertex getDestinationVertex();

}

