package com.shpp.p2p.cs.ofesenko.MyArrayList;


import java.util.Iterator;


public class MyArrayList<T> implements Iterable{
    private final int CAPACITY = 10;
    private int size=0;
    private Object[] array;

    public MyArrayList(int arraySize) {
        this.array = new Object[arraySize];
    }

    public void add (T elem){
        if (size == CAPACITY) {
//            addCapacity()
        }
        array[size]=elem;
        size++;
    }

    public void print(){
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
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
