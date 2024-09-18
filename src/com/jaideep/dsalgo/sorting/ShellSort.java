package com.jaideep.dsalgo.sorting;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[1000];
        for (int i = 1000; i > 0; i--) {
            nums[1000 - i] = i;
        }
        new ShellSort().shellShort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private void shellShort(int[] nums) {
        int n = nums.length;
        int gap = (n + 1) / 2;
        int i;
        int j;
        while (gap != 0) {
            i = 0;
            j = gap;
            while (j < n) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                    int k = i;
                    while (k >= gap && nums[k] < nums[k - gap]) {
                        swap(nums, k , k - gap);
                        k -= gap;
                    }
                }
                i++;
                j++;
            }
            gap = gap / 2;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
