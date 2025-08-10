package com.shpp.p2p.cs.ofesenko.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;


    public void add(T item) {
        if (size == 0) {
            Node<T> newItem = new Node<T>(item, first, last);
            first = last = newItem;
            size++;
        } else {
            Node<T> newItem = new Node<T>(item, last, null);
            last.next = newItem;
            last = newItem;
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public T getFirst() {
        if (size == 0) return null;
        return getItem(first);
    }

    public T getLast() {
        if (size == 0) return null;
        return getItem(last);
    }

    private T getItem(Node<T> item) {
        return item.item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> item = first;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return item != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            // Неймінг! Перейменувати змінні...
            Node<T> currentItem = item;
            item = currentItem.next;
            return currentItem.item;
        }
    }

    private static class Node<T> {
        private T item;
        private Node<T> previous;
        private Node<T> next;

        public Node(T item, Node<T> previous, Node<T> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }
}