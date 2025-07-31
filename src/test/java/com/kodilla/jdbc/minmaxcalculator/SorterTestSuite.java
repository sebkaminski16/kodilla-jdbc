package com.kodilla.jdbc.minmaxcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SorterTestSuite {

    private final int[] arrayToSort = {9, 3, 2, 4, 1, 1, 2};
    private final int[] sortedArray = {1, 1, 2, 2, 3, 4, 9};

    @Test
    public void bubbleSorter() {
        //arrange
        Sorter bubbleSorter = new BubbleSorter();
        //act
        int[] result = bubbleSorter.sort(this.arrayToSort);
        //assert
        boolean arraysEqual = Arrays.equals(result, this.sortedArray);
        Assertions.assertTrue(arraysEqual);
    }

    @Test
    public void selectionSorter() {
        //arrange
        Sorter selectionSorter = new SelectionSorter();
        //act
        int[] result = selectionSorter.sort(this.arrayToSort);
        //assert
        boolean arraysEqual = Arrays.equals(result, this.sortedArray);
        Assertions.assertTrue(arraysEqual);
    }
}
