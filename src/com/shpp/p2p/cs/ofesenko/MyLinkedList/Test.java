package com.shpp.p2p.cs.ofesenko.MyLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        // Тест 1: Порожній список
        System.out.println("Тест 1: Порожній список");
        System.out.println("Очікується size=0 → " + list.getSize());
        System.out.println("Очікується first=null → " + list.getFirst());
        System.out.println("Очікується last=null → " + list.getLast());
        System.out.println();

        // Тест 2: Додавання першого елемента
        list.add("A");
        System.out.println("Тест 2: Один елемент");
        System.out.println("Очікується size=1 → " + list.getSize());
        System.out.println("Очікується first=A → " + list.getFirst());
        System.out.println("Очікується last=A → " + list.getLast());
        System.out.println();

        // Тест 3: Додавання другого елемента
        list.add("B");
        System.out.println("Тест 3: Два елементи");
        System.out.println("Очікується size=2 → " + list.getSize());
        System.out.println("Очікується first=A → " + list.getFirst());
        System.out.println("Очікується last=B → " + list.getLast());
        System.out.println();

        // Тест 4: Додавання третього елемента
        list.add("C");
        System.out.println("Тест 4: Три елементи");
        System.out.println("Очікується size=3 → " + list.getSize());
        System.out.println("Очікується first=A → " + list.getFirst());
        System.out.println("Очікується last=C → " + list.getLast());
        System.out.println();

        System.out.println("Тест 5: For-Each");
        for (String str : list){
            System.out.println(str);
        }
    }
}
