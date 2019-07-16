/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program2)
 */
package edu.sdsu.cs.datastructures;
import java.util.PriorityQueue;
import java.util.*;

public class WDGraph<V,E> implements IGraph<V,E> {
    private List<IVertex<V>> listOfVertices;
    private List<IEdge<E>> listOfEdges;
    private HashMap<IVertex<V>,List <IEdge<E>>> actualGraph;
    private int vertexCounter = 0, edgeCounter = 0;
    private HashMap<IVertex<V>,Integer> distanceFromStartVertex = new HashMap<>(numVertices());

    public WDGraph(){
        actualGraph = new HashMap<>(100);
        listOfVertices = new ArrayList<>();
        listOfEdges = new ArrayList<>();
    }

    @Override
    public Iterable<IVertex<V>> vertices() {
        return listOfVertices;
    }

    @Override
    public Iterable<IEdge<E>> edges() {
        return listOfEdges;
    }

    @Override
    public int numEdges() {
        return edgeCounter;
    }

    @Override
    public int numVertices() {
        return vertexCounter;
    }

    @Override
    public int minimumDistance(IVertex<V> start, IVertex<V> end) {
        dijkstraAlgorithm(start,end);
        return distanceFromStartVertex.get(end);
    }

    @Override
    public Iterable<IEdge<E>> shortestPath(IVertex<V> start, IVertex<V> end) {
        List<IEdge<E>> listOfVisitedEdges = new ArrayList<>();
        HashMap<IVertex<V>, IVertex<V>> parent = printPath(start, end);
        IVertex<V> endVertex = end;
        IVertex<V> startVertex = parent.get(endVertex);
        while(!(endVertex.equals(start))) {
            List<IEdge<E>> listOfConnectedEdges = actualGraph.get(startVertex);
            for (IEdge<E> edgeFound : listOfConnectedEdges) {
                if (endVertex.equals(edgeFound.getDestinationVertex())) {
                    listOfVisitedEdges.add(edgeFound);
                }
            }
            endVertex = startVertex;
            startVertex = parent.get(startVertex);
        }
        return listOfVisitedEdges;
    }

    private HashMap<IVertex<V>,IVertex<V>>  dijkstraAlgorithm(IVertex<V> start, IVertex<V> end) {
        final int infinity = 999999999;
        List<IEdge<E>> listOfNeighbours;

        PriorityQueue<IVertex<V>> priQueue = new PriorityQueue<>(new Comparator<IVertex<V>>() {
            @Override
            public int compare(IVertex<V> vertex1, IVertex<V> vertex2) {
                return distanceFromStartVertex.get(vertex1).compareTo(distanceFromStartVertex.get(vertex2));
            }
        } );
        HashMap<IVertex<V>,IVertex<V>> parent = new HashMap<>(numVertices());
        HashSet<IVertex<V>> visited = new HashSet<>(numVertices());
        Iterator<IVertex<V>> iterateOverListOfVertices = listOfVertices.iterator();

        while(iterateOverListOfVertices.hasNext()) {
            distanceFromStartVertex.put(iterateOverListOfVertices.next(),infinity);
        }
        distanceFromStartVertex.put(start, 0);
        priQueue.offer(start);
        while(!priQueue.isEmpty()) {
            IVertex<V> curr = priQueue.poll();
            if(!visited.contains(curr)) {
                visited.add(curr);
                if(curr == end) {
                    return parent;
                }
                listOfNeighbours = actualGraph.get(curr);
                Iterator<IEdge<E>> iterateOverConnectedEdges = listOfNeighbours.iterator();
                while(iterateOverConnectedEdges.hasNext()) {
                    IEdge<E> aNeighbourEdge = iterateOverConnectedEdges.next();
                    IVertex<V> endVertex = aNeighbourEdge.getDestinationVertex();
                    int weightOnEdge = (Integer)aNeighbourEdge.getWeightOnEdge();
                    if(!visited.contains(endVertex)) {
                        if(distanceFromStartVertex.get(endVertex) > distanceFromStartVertex.get(curr) + weightOnEdge) {
                            int newDistance = distanceFromStartVertex.get(curr) + weightOnEdge;
                            distanceFromStartVertex.put(endVertex, newDistance);
                            parent.put(endVertex,curr);
                            priQueue.offer(endVertex);
                        }
                    }
                }
            }
        }
        return parent;
    }

    private HashMap<IVertex<V>,IVertex<V>>  printPath(IVertex<V> start, IVertex<V> destination) {
        HashMap<IVertex<V>,IVertex<V>> parent = dijkstraAlgorithm(start,destination);
        System.out.println(destination);
        IVertex<V> vertexToPrint = parent.get(destination);
        for(int i = 1; i < parent.size();i++) {
            if(distanceFromStartVertex.get(vertexToPrint) != 0) {
                System.out.println(vertexToPrint);
                vertexToPrint = parent.get(vertexToPrint);
            }
        }
        System.out.println(start);
        return parent;
    }

    @Override
    public void connectVertices(IVertex<V> start, IVertex<V> end, int weight) {
        IEdge edge = new WeightedEdge<>(start, end, weight);
        addEdge(edge);
        actualGraph.get(start).add(edge);
    }

    @Override
    public void addVertex(IVertex<V> toAdd) {
        listOfVertices.add(toAdd);
        actualGraph.put(toAdd,new ArrayList<IEdge<E>>());
        vertexCounter++;
    }

    @Override
    public void addEdge(IEdge<E> toAdd) {
        listOfEdges.add(toAdd);
        edgeCounter++;
    }

    public String toString() {
        String result = "Total number of vertices: "+ numVertices()+ "\n" +
                "Total number of edges: " + numEdges()+"\n" +"\nvertices: \n"+ vertices()+ "\n" +
                "\nConnections: \n";
        Iterator<IVertex<V>> listOfVertices = vertices().iterator();
        while (listOfVertices.hasNext()) {
            IVertex<V> vertex = listOfVertices.next();
            result += vertex + " => " + actualGraph.get(vertex) + "\n";
        }
        result += "\nDegree of each vertex: \n";
        listOfVertices = vertices().iterator();
        while (listOfVertices.hasNext()) {
            IVertex<V> vertex = listOfVertices.next();
            result += vertex + " => " + actualGraph.get(vertex).size() + "\n";
        }
        return result;
    }
}
