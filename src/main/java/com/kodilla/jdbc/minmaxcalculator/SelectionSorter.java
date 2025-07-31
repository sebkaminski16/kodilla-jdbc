package com.kodilla.jdbc.minmaxcalculator;

public class SelectionSorter implements Sorter {
    @Override
    public int[] sort(int... values) {
        int[] valuesArray = values.clone();
        for(int i = 0; i < valuesArray.length - 1; i++) {
            for(int j = i; j < valuesArray.length - 1; j++) {
                int lowestValue = valuesArray[i];
                int lowestValueIndex = i;
                if(lowestValue > valuesArray[j + 1]) {
                    lowestValue = valuesArray[j + 1];
                    lowestValueIndex = j + 1;
                }
                valuesArray[lowestValueIndex] = valuesArray[i];
                valuesArray[i] = lowestValue;
            }
        }
        return valuesArray;
    }
}
