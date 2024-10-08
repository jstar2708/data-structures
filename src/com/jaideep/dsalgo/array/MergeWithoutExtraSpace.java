package com.jaideep.dsalgo.array;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        int i = arr1.length - 1;
        int j = 0;
        while (i >= 0 && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
