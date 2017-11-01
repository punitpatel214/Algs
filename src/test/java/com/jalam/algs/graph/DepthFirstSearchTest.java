package com.jalam.algs.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by punit.patel on 27/10/17.
 */
public class DepthFirstSearchTest {

    @Test
    public void hasPathTo() throws Exception {
        DepthFirstSearch depthFirstSearch = constructDepthFirstSearch();
        assertThat(depthFirstSearch.hasPathTo(1), is(true));
        assertThat(depthFirstSearch.hasPathTo(2), is(true));
        assertThat(depthFirstSearch.hasPathTo(3), is(true));
        assertThat(depthFirstSearch.hasPathTo(4), is(true));
        assertThat(depthFirstSearch.hasPathTo(5), is(false));
        assertThat(depthFirstSearch.hasPathTo(6), is(false));
    }

    private DepthFirstSearch constructDepthFirstSearch() {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(5, 6);
        return new DepthFirstSearch(graph, 0);
    }

    @Test
    public void pathTo() throws Exception {
        DepthFirstSearch depthFirstSearch = constructDepthFirstSearch();
        Iterator<Integer> iterator = Arrays.asList(3, 0).iterator();
        depthFirstSearch.pathTo(4)
                .forEach(actualVertex -> assertThat(actualVertex, is(iterator.next())));

        assertThat(depthFirstSearch.pathTo(5).iterator().hasNext(), is(false));
        assertThat(depthFirstSearch.pathTo(1).iterator().next(), is(0));


    }

}