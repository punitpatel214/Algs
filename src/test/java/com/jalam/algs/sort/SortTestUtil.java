package com.jalam.algs.sort;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by punit.patel on 23/11/17.
 */
public class SortTestUtil {

    public static Integer[][] getTestSortData() {
        return new Integer[][] {
                {1, 25, 26, 14, 25, 26, 28, 26, 3, 26},
                {1, 3, 13, 14, 25, 26, 26, 28},
                {28, 26, 25, 14, 14, 13, 3},
                {1, 1, 1, 1, 1},
                {5, 4, 2, 3, 5, 1, 7, 6, 4, 9, 6, 2, 4, 3, 2, 4, 6, 7, 8}
        };
    }

    public static <T extends Comparable<? super T>> void isSorted(T[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            assertThat(SortUtility.isLessOrEqual(array[i - 1], array[i]), is(true));
        }
    }
}
