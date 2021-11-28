package com.github.arnecdn.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BestTravel {
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        List<List<Integer>> routeCache = new ArrayList<>();

        buildAllRoutes(ls, routeCache, new int[k], 0, 0, k);
        Set<Integer> validRoutesSums = sumOfValidRoutes(t, routeCache);

        return validRoutesSums.isEmpty() ? null : Collections.max(validRoutesSums);
    }

    private static Set<Integer> sumOfValidRoutes(final int maxRouteLength, final List<List<Integer>> comboCache) {
        Set<Integer> collect = comboCache.stream().map(c -> c.stream().reduce(0, Integer::sum)).collect(Collectors.toSet());
        return collect.stream().filter(integer -> integer <= maxRouteLength).collect(Collectors.toSet());
    }

    static void buildAllRoutes(List<Integer> arr, List<List<Integer>> comboCache, int[] combo, int start, int index, int steps) {
        if (index == steps) {
            List<Integer> combosAsList = Arrays.stream(combo).boxed().collect(Collectors.toList());
            comboCache.add(combosAsList);
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            combo[index] = arr.get(i);
            buildAllRoutes(arr, comboCache, combo, i + 1, index + 1, steps);
        }
    }
}


