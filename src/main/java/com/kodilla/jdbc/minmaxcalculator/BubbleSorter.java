package com.kodilla.jdbc.minmaxcalculator;

public class BubbleSorter implements Sorter {
    @Override
    public int[] sort(int... values) {
        int[] valuesArray = values.clone();
        for(int i = 0; i < valuesArray.length - 1; i++) {
            for (int j = 0; j < valuesArray.length - i - 1; j++) {
                if(valuesArray[j] > valuesArray[j + 1]) {
                    int smallerValue = valuesArray[j + 1];
                    valuesArray[j + 1] = valuesArray[j];
                    valuesArray[j] = smallerValue;
                }
            }
        }
        return valuesArray;
    }
}
