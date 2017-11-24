package com.jalam.algs.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by punit.patel on 23/11/17.
 */
public class MergeBUTest {

    @Test
    public void sort() {
        Arrays.stream(SortTestUtil.getTestSortData())
                .map(MergeBU::sort)
                .forEach(SortTestUtil::isSorted);
    }

}