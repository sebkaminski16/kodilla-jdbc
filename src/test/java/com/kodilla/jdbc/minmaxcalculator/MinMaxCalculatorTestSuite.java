package com.kodilla.jdbc.minmaxcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinMaxCalculatorTestSuite {

    private final int[] valuesArray = new int[] {4, 3, 2, 10, 15, 5, 2, 8, 5, 1, 9, 20};

    @Test
    public void testFindMaxValue() {
        //arrange
        MinMaxCalculator minMaxCalculator = new MinMaxCalculator(new BubbleSorter());
        //act
        int maxValue = minMaxCalculator.findMaxValue(this.valuesArray);
        //assert
        Assertions.assertEquals(20, maxValue);
    }

    @Test
    public void testFindMinValue() {
        //arrange
        MinMaxCalculator minMaxCalculator = new MinMaxCalculator(new SelectionSorter());
        //act
        int minValue = minMaxCalculator.findMinValue(this.valuesArray);
        //assert
        Assertions.assertEquals(1, minValue);
    }
}
