package com.jalam.algs.stack;

import java.util.NoSuchElementException;

/**
 * Created by punit.patel on 1/11/17.
 */
public class Stack<T> {

    private Node<T> last;

    public void push(T element) {
        if (last == null) {
            last = new Node<>(element);
            return;
        }
        Node<T> node = new Node(element);
        node.next = last;
        last = node;
    }

    public T peek () {
        if (last == null) {
            throw new NoSuchElementException("Empty stack");
        }
        return last.value;
    }

    public T pop() {
        if (last == null) {
            throw new NoSuchElementException("Empty stack");
        }
        Node<T> node = last;
        last = last.next;
        return node.value;
    }

    private static class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}
