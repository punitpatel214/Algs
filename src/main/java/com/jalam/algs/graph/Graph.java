package com.jalam.algs.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by punit.patel on 27/10/17.
 */
public class Graph {

    private int verticesSize;
    private List<Integer>[] edgeList;
    private int edgeSize;

    public Graph(int numOfVertices) {
        if (numOfVertices < 0) {
            throw new IllegalArgumentException();
        }
        verticesSize = numOfVertices;
        edgeList = new LinkedList[numOfVertices];
        IntStream.range(0, numOfVertices).forEach(value -> edgeList[value] = new LinkedList<>());
        System.out.println(toString());
    }

    public int vertexSize() {
        return verticesSize;
    }


    public int edgeSize() {
        return edgeSize;
    }

    public void addEdge(int vertex, int edge) {
        validateVertices(vertex);

        validateVertices(edge);

        if (vertex == edge) {
            throw new IllegalArgumentException("Vertices and edge should be different");
        }
        edgeSize++;
        edgeList[vertex].add(edge);
        edgeList[edge].add(vertex);
    }

    private void validateVertices(int vertices) {
        if (vertices < 0 || vertices >= verticesSize) {
            throw new IllegalArgumentException("Vertices value should be between 0 and " + (verticesSize - 1));
        }
    }

    public List<Integer> adjacentVertices(int vertices) {
        validateVertices(vertices);
        return edgeList[vertices];
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexSize=" + verticesSize +
                ", edgeList=" + Arrays.toString(edgeList) +
                ", edgeSize=" + edgeSize +
                '}';
    }
}
