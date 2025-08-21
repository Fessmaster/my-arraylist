package com.shpp.p2p.cs.ofesenko.MyArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Клас реалізує динамічний масив для зберігання будьяких об'єктів з використанням механізму дженериків.
 * Для зберегінна примітивних типів данних необхідно використовувати класи обгортки
 * наприклад для int треба застосовувати клас Integer
 * @param <T> - параметризований тип даних який визначає які саме об'єкти буде зберігати масив.
 */

public class MyArrayList<T> implements Iterable<T> {
    // Константа визначає початковий розмір створеного масиву
    private final int DEFAULT_CAPACITY = 5;
    // Константа визначає на скільки буде змінно розмір масиву при його повному заповненні
    private final int RESIZE_FACTOR = 2;
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;
    private Object[] array;

    /**
     * Коструктор класу який створює масив об'єктівк з ємністю визнеченою змінною capacity
     */
    public MyArrayList() {
        this.array = new Object[capacity];
    }

    /**
     * Медо повертає ємність внутрішнього масиву
     * @return - ємність внутрішнього масиву
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Метод повертає фактично доступну кількість елементів у внутрішньому масиву
     * @return - кількість елементів у внутрішньому масиві
     */
    public int size() {
        return size;
    }

    /**
     * Метод додає новий елемент до внутрішнього масиву, та збільшує змінну кількості елементів.
     * Якщо кількість елементів у масиві дорівнює ємності масиву - виклакається
     * метод resizeArray(), який створює новий масив більшого розміру.
     * @param elem - елемент, який додається до внутрішнього масиву
     */
    public void add(T elem) {
        if (size == capacity) {
            array = resizeArray();
        }
        array[size] = elem;
        size++;
    }

    /**
     * Метод повертає елемент з внутрішнього масиву за переданим індексом.
     * Якщо такий елемент відсутній то генерується виключення
     * @param index - індекс елементу у внутрішньому масиві
     * @return - повертає елемент внутрішнього масиву
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new NoSuchElementException("Element with index " + index + " not exist in list");
        return (T) array[index];
    }

    /**
     * Метод повертає перший елемент внутрішнього масиву. Якщо такий відсутній - генерується виключення.
     * @return - повертає перший елемент внутрішьного масиву.
     */
    public T getFirst() {
        if (size == 0) throw new NoSuchElementException("Element not exist in list");
        return (T) array[0];
    }

    /**
     * Метод повертає останній елемент внутрішнього масиву. Якщо такий відсутній - генерується виключення.
     * @return - повертає останній елемент внутрішьного масиву.
     */
    public T getLast() {
        if (size == 0) throw new NoSuchElementException("Element not exist in list");
        return (T) array[size - 1];
    }

    /**
     * Метод видаляє останній елемент внутрішнього, масиву змінюючи його значення на null
     * та зменшуючи кількість доступних елементів.
     * Якщо останній елемент відсутній - генерується виключення.
     */
    public void deleteLast() {
        if (size == 0) throw new NoSuchElementException("Element not exist in list");
        array[size-1]=null;
        size--;
    }

    /**
     * Метод видаляє елемент внутрішнього масиву за вказаним індексом, та зміщує
     * наступні елементи в масиві, щоб заповнити місце після видаленя та зберегти порядок
     * елементів.
     * Якщо елемент за вказаним індексом відсутній, або індекс має від'ємне значення
     * генерується виключення.
     * @param index - індекс елемента, який має бути видалений
     */
    public void delete(int index) {
        if (index < 0 || index >= size)
            throw new NoSuchElementException("Element with index " + index + " not exist in list");
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size-1]=null;
        size--;
    }

    /**
     * Метод створює новий масив збільшеної ємності та копіює всі наявні значенн
     * внутрішнього масиву.
     * @return - новий масив більшої ємності з усіма попередньо доданими елементами.
     */
    private Object[] resizeArray() {
        capacity *= RESIZE_FACTOR;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public void clear(){
        for (int i=0; i<array.length; i++){
            array[i]=null;
        }
        size = 0;
    }

    /**
     * Повертає рядкове представлення об'єкта.
     *
     * @return рядкове представлення цього об'єкта
     */
    public String toString() {
        StringBuilder allElements = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (array[i] != null)
                allElements = (i != array.length - 1) ? allElements.append(array[i]+" ")  : allElements.append(array[i]);
        }
        return (allElements.toString());
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("Next element not exist");
            return (T) (array[currentIndex++]);
        }
    }
}
