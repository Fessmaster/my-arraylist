package com.shpp.p2p.cs.ofesenko.MyLinkedList;

import java.util.NoSuchElementException;
import java.util.Objects;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
//        int[] array = {1,2,3,4,5,6,7,8};
//        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};


//        testCollection("Test 1. Size in empty array", 0, list.size());
//        testException("Test 2. Try to get element in empty array", () -> list.getFirst(), NoSuchElementException.class);
//        list.add(array[0]);
//        testCollection("Test 3. Size with 1 element",1, list.size());
//        list.add(array[1]);
//        list.add(array[2]);
//        list.add(array[3]);
//        list.add(array[4]);
//        list.deleteFirst();
//        testCollection("Test 4. Size with 4 elements",4, list.size());
//        testCollection("Test 4. ________________",array[1], list.getFirst());
//        testCollection("Test 4. ________________",array[4], list.getLast());
//        testCollection("Test 5. Get element from 3 position",array[3], list.get(3));
//        testCollection("Test 6. Get element from 4 position",array[4], list.get(4));
//        testCollection("Test 7. Get array capacity",5, list.getCapacity());
//        list.add(array[5]);
//        testCollection("Test 8. Size with 6 elements",6, list.size());
//        testCollection("Test 9. Checking an increase in array in the collection",10, list.getCapacity());
//        list.deleteLast();
//        testCollection("Test 10. Size after deleting last element",5, list.size());
//        testException("Test 11. Try to get element which was removed", () -> list.get(5), NoSuchElementException.class);
//        list.add(array[5]);
//        list.add(array[6]);
//        list.add(array[7]);
//        testCollection("Test 12. Get first element, with list.getFirst()",array[0], list.getFirst());
//        testCollection("Test 13. Get last element, with list.getLast()",array[array.length-1], list.getLast());
//        System.out.println(" - Test 14. Testing the for-Each cycle");
//        int i=0;
//        for (Object element : list){
//            testCollection("", array[i], element);
//            i++;
//        }
//        testCollection("Test 15. Size with 8 elements",8, list.size());
//        list.delete(3);
//        testCollection("Test 16. Size with after delete element from middle",7, list.size());
//        testCollection("Test 17. Get element from position after delete",array[4], list.get(3));
//        list.add(null);
//        testCollection("Test 18. Get element null",null, list.getLast());
//        list.clear();
//        testCollection("Test 19. Size of collection after cleaning", 0, list.size());
//        testCollection("Test 20. Get array capacity",10, list.getCapacity());
//        testException("Test 21. Try to get negative element", () -> list.get(-1), NoSuchElementException.class);
//        testException("Test 22. Try to delete negative elment", () -> list.delete(-1), NoSuchElementException.class);

        for(int i=0; i<array.length; i++){
            list.add(array[i]);
        }
        for (Object item:list){
            System.out.print(item+" ");
        }
        list.clear();
        System.out.println(list.size());
        for (Object item:list){
            System.out.print(item+" ");
        }
        list.getFirst();


    }





    public static void testCollection(String testName, Object expected, Object current) {
        System.out.println(" - "+testName+":");
        if (Objects.equals(expected, current)) System.out.print("✅ ");
        else System.out.print("❌ ");
        System.out.print("Expected -> " + expected + ";");
        System.out.println(" Current -> "+current + "; ");
    }

    public static void testException(String testName, Runnable action, Class<? extends Throwable> expectedException) {
        System.out.println(" - "+testName+":");
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
