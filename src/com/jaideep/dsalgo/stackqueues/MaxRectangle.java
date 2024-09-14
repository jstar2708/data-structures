package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class MaxRectangle {
    private static final Stack<Integer> stack = new Stack<>();

    public int maxArea(int[][] M, int n, int m) {
        for (int i = 1; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] != 0) {
                    M[i][j] += M[i - 1][j];
                }
            }
        }
        int mxArea = 0;
        for (int i = 0; i < M.length; i++) {
            mxArea = Math.max(findMaxArea(M[i]), mxArea);
        }
        return mxArea;
    }

    private int findMaxArea(int[] nums) {
        int[] ls = new int[nums.length];
        int[] rs = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                ls[i] = -1;
            } else if (nums[i] > nums[stack.peek()]) {
                ls[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                    stack.pop();
                }
                ls[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                rs[i] = nums.length;
            } else if (nums[i] > nums[stack.peek()]) {
                rs[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                    stack.pop();
                }
                rs[i] = stack.isEmpty() ? nums.length : stack.peek();
            }
            stack.push(i);
        }

        int mxArea = 0;
        for (int i = 0; i < nums.length; i++) {
            mxArea = Math.max(nums[i] * Math.abs(rs[i] - ls[i] - 1), mxArea);
        }
        stack.clear();
        return mxArea;
    }
}
