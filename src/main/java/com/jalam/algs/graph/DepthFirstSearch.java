package com.jalam.algs.graph;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by punit.patel on 27/10/17.
 */
public class DepthFirstSearch {
    private int source;
    private boolean[] mark;
    private int[] edges;

    public DepthFirstSearch(Graph graph, int source) {
        this.source = source;
        mark = new boolean[graph.vertexSize()];
        edges = new int[graph.vertexSize()];
        Arrays.fill(mark, false);
        dfs(graph, source);
    }

    private void dfs(Graph graph, int vertex) {
        mark[vertex] = true;
        graph.adjacentVertices(vertex)
                .forEach(adjVertex -> {
                    if (!mark[adjVertex]) {
                        edges[adjVertex] = vertex;
                        dfs(graph, adjVertex);
                    }
                });
    }

    public boolean hasPathTo(int vertex) {
        return mark[vertex];
    }

    public Iterable<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return Collections.emptyList();
        }
        Stack stack = new Stack();
        while (edges[vertex] != source) {
            int edge = edges[vertex];
            stack.push(edge);
            vertex = edge;
        }
        stack.push(source);
        return stack;
    }

}

class Stack implements Iterable<Integer> {
    private Node last;

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator(last);
    }

    class StackIterator implements Iterator<Integer> {
        Node curr;

        public StackIterator(Node curr) {
            this.curr = curr;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Integer next() {
            int element = curr.element;
            curr = curr.next;
            return element;
        }


    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }

    private static class Node {
        int element;
        Node next;

        public Node(int element) {
            this.element = element;
        }
    }

    public void push(int element) {
        Node node = new Node(element);
        node.next = last;
        last = node;
    }

    public int pop() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        Node node = last;
        last = last.next;
        int element = last.element;
        last = null;
        return element;
    }
}



