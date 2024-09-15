package com.jaideep.dsalgo.searching;

public class OrderAgnosticBinarySearch {
    private int BS(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        boolean asc = nums[low] < nums[high];
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (asc) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (asc) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
