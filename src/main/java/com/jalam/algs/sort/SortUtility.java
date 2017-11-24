package com.jalam.algs.sort;

public class SortUtility {
    public static <T extends Comparable<? super T>> boolean isLessOrEqual(T element, T compareWithElement) {
        return element.compareTo(compareWithElement) <= 0;
    }

    public static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
