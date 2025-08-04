package com.shpp.p2p.cs.ofesenko.MyArrayList;

public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>(10);
        numbers.add(5);
        numbers.add(11);
        numbers.add(2);
        numbers.add(3);

        numbers.print();
    }
}
