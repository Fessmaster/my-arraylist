package com.shpp.p2p.cs.ofesenko.MyArrayList;

import java.util.Iterator;


public class MyArrayList<T> implements Iterable {
    private int capacity = 10;
    private int size = 0;
    private Object[] array;

    public MyArrayList() {
        this.array = new Object[capacity];
    }

    public MyArrayList(int arraySize) {
        this.array = new Object[arraySize];
        this.capacity = arraySize;

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

    private Object[] resizeArray() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                System.out.print(array[i] + " ");
        }
    }

    public String toString() {
        String allElements = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                allElements = (i != array.length - 1) ? allElements + array[i] + " " : allElements + array[i];
        }
        return ("[" + allElements + "]");
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return null;
    }
}
