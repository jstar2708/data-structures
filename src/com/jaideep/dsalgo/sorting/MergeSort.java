package com.jaideep.dsalgo.sorting;

public class MergeSort {
    private void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] A = new int[n1];
        int[] B = new int[n2];
        for (int i = 0; i < n1; i++) {
            A[i] = nums[low + i];
        }
        for (int j = 0; j < n2; j++) {
            B[j] = nums[mid + 1 + j];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (A[i] > B[j]) {
                nums[k] = B[j];
                j++;
            } else {
                nums[k] = A[i];
                i++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = A[i];
            i++;
            k++;
        }
        while (j < n2) {
            nums[k] = B[j];
            j++;
            k++;
        }
    }
}
