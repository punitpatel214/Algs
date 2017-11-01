package com.jalam.algs.graph;

import java.util.NoSuchElementException;

/**
 * Created by punit.patel on 31/10/17.
 */
public class BreadthFirstSearch {
    private int source;
    private Graph graph;
    private boolean[] mark;
    private int[] edgeTo;
    private Queue queue;

    public BreadthFirstSearch(Graph graph, int source) {
        mark = new boolean[graph.vertexSize()];
        edgeTo = new int[graph.vertexSize()];
        queue = new Queue();
        bfs(graph, source);
    }

    private void bfs(Graph graph, int vertex) {
        queue.enque(vertex);
        while (!queue.isEmpty()) {
            int v = queue.deque();
            mark[v] = true;
            graph.adjacentVertices(v)
                    .forEach(adjVertex -> {
                        edgeTo[adjVertex] = v;
                        if (!mark[adjVertex]) {
                            queue.enque(adjVertex);
                        }
                    });
        }
    }

    public boolean hasPathTo(int i) {
        return mark[i];
    }
}

class Queue {
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void enque(int value) {
        if (first == null) {
            first = last = new Node(value);
            return;
        }
        Node node = new Node(value);
        last.next = node;
        last = node;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int deque() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node node = first;
        first = first.next;
        return node.value;
    }
}