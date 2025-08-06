package com.shpp.p2p.cs.ofesenko.MyArrayList;


import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;


public class Test extends WindowProgram {
    static MyArrayList<GOval> oval;

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("C");
        list.add("C");
        System.out.println(list.size()); // 3

        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.delete(4);
        System.out.println(list);










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
