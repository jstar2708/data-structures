package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int[] nextGreater = new int[nums2.length];
        final Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                nextGreater[i] = -1;
            }
            else if (nums2[i] >= nums2[stack.peek()]) {
                while (!stack.isEmpty() && nums2[i] >= nums2[stack.peek()]) {
                    stack.pop();
                }
                nextGreater[i] = stack.isEmpty() ? -1 : nums2[stack.peek()];
            }
            else {
                nextGreater[i] = nums2[stack.peek()];
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    nums1[i] = nextGreater[j];
                    break;
                }
            }
        }
        return nums1;
    }
}
