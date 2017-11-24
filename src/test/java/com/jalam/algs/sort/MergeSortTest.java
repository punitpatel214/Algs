package com.jalam.algs.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by punit.patel on 23/11/17.
 */
public class MergeSortTest {

    @Test
    public void sort() {
        Arrays.stream(SortTestUtil.getTestSortData())
                .map(MergeSort::sort)
                .forEach(SortTestUtil::isSorted);
    }


}