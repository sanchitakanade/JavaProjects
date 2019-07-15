/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program2)
 */
package edu.sdsu.cs.datastructures;

public class GraphVertex<V> implements IVertex<V> {
    private V cityName;
    private V tacticalZone;

    public GraphVertex(V cityName, V tacticalZone) {
        this.cityName = cityName;
        this.tacticalZone = tacticalZone;
    }

    @Override
    public V getCityName() {
        return this.cityName;
    }

    public String toString() {
        return "" + cityName ;
    }

    public boolean equals(Object vertex) {
        GraphVertex<V> aVertex = (GraphVertex<V>)vertex;
        return getCityName().equals(aVertex.getCityName());
    }
    public int hashCode() {
        return cityName.hashCode();
    }
}

