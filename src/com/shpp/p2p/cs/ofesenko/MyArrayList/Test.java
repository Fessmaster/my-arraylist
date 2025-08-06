package com.shpp.p2p.cs.ofesenko.MyArrayList;


import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;


public class Test extends WindowProgram {
    static MyArrayList<GOval> oval;

    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>(5);
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        numbers.print();
        numbers.deleteLast();
        System.out.println();
        numbers.print();
        System.out.println();
        System.out.println(numbers.getLast());



    }


    private static GOval addOval(int i) {
        GOval oval = new GOval(i*100-50, i*100-50, i*100-50, i*100-50 );
        oval.setFilled(true);
        oval.setFillColor(Color.GREEN);
        oval.setColor(Color.WHITE);
        return oval;
    }

//    public void run(){
//        oval = new MyArrayList<>(3);
//        for (int i = 0; i< 3; i++){
//            oval.add(addOval(i));
//        }
//        oval.print();
//        System.out.println();
//        System.out.println("Size: "+ oval.size());
//        System.out.println("Capacity: "+ oval.getCapacity());
//
//        for (int i = 0; i< oval.size(); i++){
//            add(oval.get(i));
//        }
//    }
}
