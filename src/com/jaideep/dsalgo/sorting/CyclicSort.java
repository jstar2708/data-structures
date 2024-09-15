package com.jaideep.dsalgo.sorting;

import java.util.Arrays;

public class CyclicSort {
    private void cyclicSort(int[] nums) {
        int n = nums.length;
        int j = 0;
        while (j < n) {
            if (nums[j] == nums[nums[j] - 1]) {
                j++;
            } else {
                swap(nums, j, nums[j] - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
