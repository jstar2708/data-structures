package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int k = Integer.MIN_VALUE;
        final Stack<Integer> stack = new Stack<>();
        stack.push(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            } else if (nums[i] > stack.peek()) {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    k = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
