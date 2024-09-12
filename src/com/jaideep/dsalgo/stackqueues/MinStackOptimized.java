package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class MinStackOptimized {
    private final Stack<Long> stack;
    private long min = Long.MAX_VALUE;

    public MinStackOptimized() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push((long) val);
        } else if (min > val) {
            stack.push(2 * (long) val - min);
            min = val;
        } else {
            stack.push((long) val);
        }
    }

    public void pop() {
        if (stack.peek() < min) {
            min = 2 * min - stack.peek();
        }
        stack.pop();
    }

    public int top() {
        if (stack.peek() < min) {
            return (int) min;
        }
        long top = stack.peek();
        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}
