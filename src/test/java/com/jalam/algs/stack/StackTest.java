package com.jalam.algs.stack;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by punit.patel on 1/11/17.
 */
public class StackTest {

    @Test
    public void testStackFunctionality() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertThat(stack.pop(), is(1));
        stack.push(2);
        assertThat(stack.peek(), is(2));
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertThat(stack.pop(), is(5));
        assertThat(stack.pop(), is(4));
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException() {
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }

}