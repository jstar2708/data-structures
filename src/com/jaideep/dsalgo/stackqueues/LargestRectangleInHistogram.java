package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		final int n = heights.length;
		final Stack<Integer> stack = new Stack<>();
		final int[] leftSmaller = new int[n];
		final int[] rightSmaller = new int[n];
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				leftSmaller[i] = -1;
			}
			else if (heights[i] <= heights[stack.peek()]) {
				while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
					stack.pop();
				}
				leftSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
			}
			else {
				leftSmaller[i] = stack.peek();
			}
			stack.push(i);
		}

		stack.clear();

		for (int i = n-1; i >= 0; i--) {
			if (stack.isEmpty()) {
				rightSmaller[i] = n;
			}
			else if (heights[i] <= heights[stack.peek()]) {
				while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
					stack.pop();
				}
				rightSmaller[i] = stack.isEmpty() ? n : stack.peek();
			}
			else {
				rightSmaller[i] = stack.peek();
			}
			stack.push(i);
		}

		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			maxArea = Math.max(maxArea, Math.abs(rightSmaller[i] - (leftSmaller[i] + 1)) * heights[i]);
		}
		return maxArea;
  	}
}
