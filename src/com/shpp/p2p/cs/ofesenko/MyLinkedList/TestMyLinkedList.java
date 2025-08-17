package com.shpp.p2p.cs.ofesenko.MyLinkedList;

import java.util.NoSuchElementException;
import java.util.Objects;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Object> list = new MyLinkedList<>();
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
//        int[] array = {1,2,3,4,5,6,7,8};
//        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};


        testCollection("Test 1. Size in empty array", 0, list.size());
        testException("Test 2. Try to get element in empty array", () -> list.getFirst(), NoSuchElementException.class);
        list.add(array[0]);
        testCollection("Test 3. Size with 1 element", 1, list.size());
        list.add(array[1]);
        list.add(array[2]);
        list.add(array[3]);
        list.add(array[4]);
        list.deleteFirst();
        testCollection("Test 4. Size with 4 elements", 4, list.size());
        testCollection("Test 5. Access to the first item after deleting first item", array[1], list.getFirst());
        list.deleteLast();
        testCollection("Test 6. Size with 3 elements", 3, list.size());
        testCollection("Test 7. Access to the last item after deleting last item", array[3], list.getLast());
        list.clear();
        testCollection("Test 8. List size after using the method clear()", 0, list.size());
        testException("Test 9. Try to get element in empty array", () -> list.getFirst(), NoSuchElementException.class);
        testException("Test 10. Try to get element in empty array", () -> list.getLast(), NoSuchElementException.class);
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        System.out.println(" - Test 11. Testing the for-each cycle");
        int i = 0;
        for (Object element : list) {
            testCollection("", array[i], element);
            i++;
        }
        testCollection("Test 12. Size with 8 elements", 8, list.size());
    }

    public static void testCollection(String testName, Object expected, Object current) {
        System.out.println(" - " + testName + ":");
        if (Objects.equals(expected, current)) System.out.print("✅ ");
        else System.out.print("❌ ");
        System.out.print("Expected -> " + expected + ";");
        System.out.println(" Current -> " + current + "; ");
    }

    public static void testException(String testName, Runnable action, Class<? extends Throwable> expectedException) {
        System.out.println(" - " + testName + ":");
        try {
            action.run();
            System.out.println("❌ Expected exception: " + expectedException.getSimpleName() +
                    ", but no exception was thrown.");
        } catch (Throwable e) {
            if (expectedException.isInstance(e)) {
                System.out.println("✅ Caught expected exception: " + e.getClass().getSimpleName());
            } else {
                System.out.println("❌ Expected exception " + expectedException.getSimpleName() +
                        ", but caught: " + e.getClass().getSimpleName());
            }
        }
    }
}
