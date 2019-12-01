package com.github.arnecdn.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZywOo {
    public static int sumOfDifferences(int[] arr) {
        Arrays.sort(arr);
        List<Integer> delSummer = new ArrayList();
        for(int i = arr.length-1; i > 0; i--){
            int sum = arr[i] - arr[i-1];
            delSummer.add(sum);
        }

        return delSummer.stream().mapToInt(i -> i).sum();
    }
}
