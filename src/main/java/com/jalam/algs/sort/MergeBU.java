package com.jalam.algs.sort;

import java.util.stream.IntStream;

public class MergeBU {

    public static Comparable[] sort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];

        for (int size = 1; size < array.length; size = size + size) {
            for (int low = 0; low < array.length; low += size + size) {
                merge(array, aux, low, low + size - 1, Math.min(low + size + size - 1, array.length - 1));
            }
        }
        return array;
    }

    private static void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        IntStream.rangeClosed(low, high).forEach(value -> aux[value] = array[value]);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > high) {
                array[k] = aux[i++];
            } else if (SortUtility.isLessOrEqual(aux[i], aux[j])) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }
}
