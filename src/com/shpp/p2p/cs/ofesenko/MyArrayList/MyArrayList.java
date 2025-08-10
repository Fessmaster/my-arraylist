package com.shpp.p2p.cs.ofesenko.MyArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyArrayList<T> implements Iterable<T> {
    private final int DEFAULT_CAPACITY = 5;
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;
    private Object[] array;

    public MyArrayList() {
        this.array = new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public void add(T elem) {
        if (size == capacity) {
            array = resizeArray();
        }
        array[size] = elem;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new NoSuchElementException("Element with index " + index + " not exist in list");
        return (T) array[index];
    }

    public T getFirst() {
        if (size == 0) throw new NoSuchElementException("Element not exist in list");
        return (T) array[0];
    }

    public T getLast() {
        if (size == 0) throw new NoSuchElementException("Element not exist in list");
        return (T) array[size - 1];
    }

    public void deleteLast() {
        if (size == 0) throw new NoSuchElementException("Element not exist in list");
        array[size-1]=null;
        size--;
    }

    public void delete(int index) {
        if (index < 0 || index >= size)
            throw new NoSuchElementException("Element with index " + index + " not exist in list");
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size-1]=null;
        size--;
    }

    private Object[] resizeArray() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public void clear(){
        for (int i=0; i<array.length; i++){
            array[i]=null;
        }
        size = 0;
    }

    // ПЕРЕРОБИТИ ________________________________________________________________
    public String toString() {
        String allElements = "";
        for (int i = 0; i < size; i++) {
            if (array[i] != null)
                allElements = (i != array.length - 1) ? allElements + array[i] + " " : allElements + array[i];
        }
        return (allElements);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("Next element not exist");
            return (T) (array[currentIndex++]);
        }
    }
}
