package com.shpp.p2p.cs.ofesenko.MyLinkedList;

public class MyLinkedList<T> {
    private int size = 0;
    private T element;
    private MyLinkedList previous = null;
    private MyLinkedList current = null;
    private MyLinkedList next = null;


    public void add(T element) {
        if (size > 0) this.previous = curret;
        this.current=this;
        this.element = element;

    }

    private class Node <T>{
        private T element;
    }
}