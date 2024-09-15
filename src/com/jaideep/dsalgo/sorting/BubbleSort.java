package com.jaideep.dsalgo.sorting;

import java.util.Arrays;

public class BubbleSort {

    private void bubbleSort(int[] nums) {
        int counter = 1;
        int flag = 0;
        while (counter < nums.length) {
            for (int i = 0; i < nums.length - counter; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    flag = 1;
                }
            }
            if (flag == 0) break;
            counter++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
