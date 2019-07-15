/*
Name:Sanchita Kanade
Edoras Class Account: cssc0225
CS310 summer 2018 (Program2)
 */
package edu.sdsu.cs;

import edu.sdsu.cs.datastructures.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class App
{
    private class FirstAndLastVertex<V> {
        IVertex<V> firstVertex;
        IVertex<V> lastVertex;
    }

    private <V,E> FirstAndLastVertex<V> addToGraph(String csvFileName, IGraph<V,E> graph, String taskToDo) throws IOException {
        String line ;
        int vertexCounter = 1;
        FirstAndLastVertex<V> vertexDetails = new FirstAndLastVertex<>();
        IVertex<V> startVertex = null, endVertex = null;
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        try {
            fileReader = new FileReader(csvFileName);
            bufferReader = new BufferedReader(fileReader);

            while((line = bufferReader.readLine()) != null) {
                String[] vertexOrEdgeDetails = line.split(",");

                if (taskToDo.equals("addVertices")) {
                    IVertex vertex = new GraphVertex<>(vertexOrEdgeDetails[0], vertexOrEdgeDetails[1]);
                    graph.addVertex(vertex);
                    if (vertexCounter == 1) {
                        vertexDetails.firstVertex = vertex;
                    }
                    vertexCounter++;
                    vertexDetails.lastVertex = vertex;
                }
                if (taskToDo.equals("addEdges")) {
                    Iterator<IVertex<V>> listOfVertices = graph.vertices().iterator();
                    while (listOfVertices.hasNext()) {
                        IVertex<V> aVertex = listOfVertices.next();
                        if (aVertex.getCityName().equals(vertexOrEdgeDetails[0])) {
                            startVertex = aVertex;
                        }
                        if (aVertex.getCityName().equals(vertexOrEdgeDetails[1])) {
                            endVertex = aVertex;
                        }
                    }
                    graph.connectVertices(startVertex, endVertex, Integer.parseInt(vertexOrEdgeDetails[2]));
                }
            }
        }finally {
            if (fileReader != null && bufferReader != null) {
                try {
                    bufferReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Caught IOException: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return vertexDetails;
    }

    public static void main(String[] args) {
        App app = new App();
        IGraph<String,Integer> graph = new WDGraph<>();
        App.FirstAndLastVertex<String> firstAndLastVertices;
        try{
            if(args.length == 0) {
                firstAndLastVertices = app.addToGraph("cities.csv", graph, "addVertices");
                app.addToGraph("edges.csv", graph, "addEdges");
                System.out.println("Graph Details:\n" + graph);
                System.out.println("Shortest Path between " + firstAndLastVertices.firstVertex + " and "
                        + firstAndLastVertices.lastVertex + "\nvertices visited:");
                Iterator<IEdge<Integer>> edgeIterator = graph.shortestPath(firstAndLastVertices.firstVertex,firstAndLastVertices.lastVertex).iterator();
                System.out.println("\nedges visited:");
                while(edgeIterator.hasNext()){
                    System.out.println(edgeIterator.next());
                }
                System.out.println("\nminimum distance for the route: " + graph.minimumDistance(firstAndLastVertices.firstVertex, firstAndLastVertices.lastVertex));
            } else if(args.length == 2 && args[0].endsWith(".csv") && args[1].endsWith(".csv")) {
                firstAndLastVertices = app.addToGraph(args[0], graph, "addVertices");
                app.addToGraph(args[1], graph, "addEdges");
                System.out.println("Graph Details:\n" + graph);
                System.out.println("Shortest Path between " + firstAndLastVertices.firstVertex + " and "
                        + firstAndLastVertices.lastVertex + "\nvertices visited:");
                Iterator<IEdge<Integer>> edgeIterator = graph.shortestPath(firstAndLastVertices.firstVertex, firstAndLastVertices.lastVertex).iterator();
                System.out.println("\nedges visited:");
                while(edgeIterator.hasNext()){
                    System.out.println(edgeIterator.next());
                }
                System.out.println("\nminimum distance for the route: " + graph.minimumDistance(firstAndLastVertices.firstVertex, firstAndLastVertices.lastVertex));
            } else if(args.length < 2) {
                throw new InvalidFileException("Error: Incorrect number of input arguments (0 or 2 expected), " + args.length + " provided.");
            } else {
                throw new InvalidFileException("Error: Please enter valid files, csv files are expected." +
                        " \nExpected first argument: vertexFile.csv (csv file containing details of vertices)" +
                        ",\nExpected second argument: edgesFile.csv (csv file containing details of edges)");
            }

        } catch(FileNotFoundException exception) {
            System.out.println("Error: File not found: Please provide csv files for vertices and edges details respectively" +
                    "\nExpected first argument: vertexFile.csv (csv file containing details of vertices)" +
                    "\nExpected second argument: edgesFile.csv (csv file containing details of edges)" +
            "\nFor default operation mode(no program arguments) use file names 'cities.csv' and 'edges.csv' for vertices and edges files respectively");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static class InvalidFileException extends Exception {
        private InvalidFileException(String message) {
            super(message);
        }
    }

}

