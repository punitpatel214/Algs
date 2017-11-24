package com.jalam.algs.sort;

/**
 * Created by punit.patel on 23/11/17.
 */
public class MergeXSort {

    public static Comparable[] sort(Comparable[] array) {
        sort(array, array.clone(), 0, array.length - 1);
        return array;
    }

    private static void sort(Comparable[] src, Comparable[] dst, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = (low + high) / 2;
        sort(dst, src, low, mid);
        sort(dst, src, mid + 1, high);
        merge(src, dst, low, mid, high);
    }

    private static void merge(Comparable[] src, Comparable[] dst, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                src[k] = dst[j++];
            } else if (j > high) {
                src[k] = dst[i++];
            } else if (SortUtility.isLessOrEqual(dst[i], dst[j])) {
                src[k] = dst[i++];
            } else {
                src[k] = dst[j++];
            }
        }
    }
}
