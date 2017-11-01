package com.jalam.algs.graph;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by punit.patel on 27/10/17.
 */
public class GraphTest {

    @Test
    public void testAddEdge() {
        Graph graph = new Graph(3);
        assertThat(graph, notNullValue());
        assertThat(graph.vertexSize(), is(3));
        assertThat(graph.edgeSize(), is(0));

        graph.addEdge(1, 2);
        assertThat(graph.edgeSize(), is(1));
        assertThat(graph.adjacentVertices(1)
                .stream().anyMatch(integer -> integer.equals(2)), is(true));
        assertThat(graph.adjacentVertices(2)
                .stream().anyMatch(integer -> integer.equals(1)), is(true));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {
        Graph graph = new Graph(3);
        graph.addEdge(1, 1);
    }
}