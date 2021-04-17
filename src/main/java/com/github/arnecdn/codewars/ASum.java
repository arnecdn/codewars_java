package com.github.arnecdn.codewars;

public class ASum {
    public static long findNb(long m) {
        long n = 0;
        long i = 0;

        while (n < m) {
            n += (long) (Math.pow(++i, 3));
        }

        return (n == m) ? i : -1;
    }

}
//4183059834009
//4183059834010