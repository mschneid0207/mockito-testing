package de.mschneid.unittesting.business;

import de.mschneid.unittesting.data.SomeDataService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }


    public int calculateSum(int[] data) {
        int sum = IntStream.of(data).sum();
        return sum;
    }

    public int calculateSumWithDataService() {
        int[] data = someDataService.retrieveAllData();
        int sum = IntStream.of(data).sum();
        return sum;
    }
}
