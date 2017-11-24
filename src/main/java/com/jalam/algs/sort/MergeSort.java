package com.jalam.algs.sort;

import java.util.stream.IntStream;

public class MergeSort {


    public static Comparable[] sort(Comparable[] array) {
        mergerSort(array, new Comparable[array.length], 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<? super T>> void mergerSort(T[] array, T[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = (low + high) / 2;
        mergerSort(array, aux, low, mid);
        mergerSort(array, aux, mid + 1, high);
        merge(array, aux, low, mid, high);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array, T[] aux, int low, int mid, int high) {
        IntStream.rangeClosed(low, high)
                .forEach(value -> aux[value] = array[value]);
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