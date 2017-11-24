package com.jalam.algs.sort;

public class InsertionSort {

    public static <T extends Comparable<? super T>> T[] sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && SortUtility.isLessOrEqual(array[j], array[j - 1]); j--) {
                SortUtility.swap(array, j, j - 1);
            }
        }
        return array;
    }
}
