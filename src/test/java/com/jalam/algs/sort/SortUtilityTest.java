package com.jalam.algs.sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SortUtilityTest {

    @Test
    public void isLess() throws Exception {
        assertThat(SortUtility.isLessOrEqual(Integer.valueOf(5), Integer.valueOf(6)), is(true));
        assertThat(SortUtility.isLessOrEqual(Integer.valueOf(7), Integer.valueOf(6)), is(false));
        assertThat(SortUtility.isLessOrEqual(Integer.valueOf(5), Integer.valueOf(5)), is(false));
        assertThat(SortUtility.isLessOrEqual(Integer.valueOf(-5), Integer.valueOf(6)), is(true));
        assertThat(SortUtility.isLessOrEqual(Integer.valueOf(0), Integer.valueOf(6)), is(true));
    }

}