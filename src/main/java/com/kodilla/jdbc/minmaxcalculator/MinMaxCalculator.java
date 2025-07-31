package com.kodilla.jdbc.minmaxcalculator;

public class MinMaxCalculator {

    private Sorter sorter;

    public MinMaxCalculator(Sorter sorter) {
        this.sorter = sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public int findMaxValue(int... values) {
        this.validate(values);
        int[] sorted = this.sorter.sort(values);
        return sorted[sorted.length - 1];
    }
    public int findMinValue(int... values) {
        this.validate(values);
        int[] sorted = this.sorter.sort(values);
        return sorted[0];
    }

    private void validate(int... values) {
        if(values.length == 0) {
            throw new IllegalArgumentException("You have to pass at least one value!");
        }
    }
}
