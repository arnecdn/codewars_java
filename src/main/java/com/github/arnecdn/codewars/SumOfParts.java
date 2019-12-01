package com.github.arnecdn.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class SumOfParts {
    public static int[] sumParts(int[] ls) {

        List<Integer> summer = new ArrayList(ls.length);
        int arraySum = 0;

        for (int i = 0; i < ls.length; i++) {
            arraySum += ls[i];
        }
        summer.add(arraySum);

        for (int i = 0; i < ls.length; i++) {
            arraySum = arraySum - ls[i];
            summer.add(arraySum);
        }
        return summer.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }

    public static int[] sumPartsSequencial(int[] ls) {

        final List<Integer> collect = new ArrayList<>();
        collect.add(0);
        for (int i = 0; i < ls.length; i++) {
            final int sum = Arrays.stream(Arrays.copyOfRange(ls, i, ls.length)).sum();
            collect.add(sum);
        }

        return collect.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }

    public static int[] sumPartsRecursive(int[] ls) {

        if (ls.length == 0) {
            int[] initialSumParts = new int[1];
            initialSumParts[0] = 0;
            return initialSumParts;
        }

        final int sum = Arrays.stream(ls).sum();
        final int[] subArray = Arrays.copyOfRange(ls, 1, ls.length);
        final int[] sumParts = sumParts(subArray);

        final List<Integer> collect = Arrays.stream(sumParts).boxed().collect(Collectors.toList());
        collect.add(sum);
        return collect.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }
}
