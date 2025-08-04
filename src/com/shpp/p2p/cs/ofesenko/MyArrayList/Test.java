package com.shpp.p2p.cs.ofesenko.MyArrayList;

public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>(3);
        numbers.add(5);
        numbers.add(2);
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(1);
        numbers.add(7);
        numbers.add(7);
        numbers.add(7);
        numbers.add(7);
        numbers.add(7);

        numbers.print();
        System.out.println();
        System.out.println("Size: "+numbers.size());
        System.out.println("Capacity: "+numbers.getCapacity());



    }
}
