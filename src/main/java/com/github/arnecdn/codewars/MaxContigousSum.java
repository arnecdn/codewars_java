package com.github.arnecdn.codewars;

public class MaxContigousSum {
        public static int maxContiguousSum(final int[] arr) {
            int maxSum = 0;
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                sum  += arr[i];

                if(sum < 0){
                    sum=0;
                }else if (maxSum < sum){
                    maxSum = sum;
                }
            }

            return maxSum;
        }

    public static int maxContiguousSum2(final int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(sum < 0){
                sum=0;
            }else if (maxSum < sum){
                maxSum = sum;
            }
            sum  += arr[i];
        }

        return maxSum;
    }

    public static int maxContiguousSum1(final int[] arr) {
        int maxSum = 0;

        for(int i = 0; i < arr.length; i++){
            int sum = 0;

            for(int j = i;j< arr.length; j++){
                sum  += arr[j];

                if(sum>maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}
