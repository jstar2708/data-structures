package com.jaideep.dsalgo.sorting;

public class MergeWithoutExtraSpaceShellSort {
    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        int gap = (m + n) / 2;
        while (true) {
            for (int i = 0, j = gap; j < m + n; i++, j++) {
                if (i < n && j < n) {
                    swapIfGreater(arr1, arr1, i, j);
                } else if (i < n && j >= n) {
                    swapIfGreater(arr1, arr2, i, j - n);
                } else if (i >= n && j >= n) {
                    swapIfGreater(arr2, arr2, i - n, j - n);
                }
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + gap % 2;
        }
    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int i, int j) {
        if (arr1[i] > arr2[j]) {
            long temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }

    }
}
