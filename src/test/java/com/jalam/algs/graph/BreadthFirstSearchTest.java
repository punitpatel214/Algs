package com.jalam.algs.graph;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by punit.patel on 31/10/17.
 */
public class BreadthFirstSearchTest {

    @Test
    public void testHasPathTo() {
        BreadthFirstSearch breadthFirstSearch = constructBreadthFirstSearch();
        assertThat(breadthFirstSearch.hasPathTo(1), is(true));
        assertThat(breadthFirstSearch.hasPathTo(2), is(true));
        assertThat(breadthFirstSearch.hasPathTo(3), is(true));
        assertThat(breadthFirstSearch.hasPathTo(4), is(true));
        assertThat(breadthFirstSearch.hasPathTo(5), is(false));
        assertThat(breadthFirstSearch.hasPathTo(6), is(false));
    }

    private BreadthFirstSearch constructBreadthFirstSearch() {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(5, 6);
        return new BreadthFirstSearch(graph, 0);
    }
}