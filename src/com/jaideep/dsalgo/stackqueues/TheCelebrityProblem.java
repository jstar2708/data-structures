package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class TheCelebrityProblem {
    public int celebrity(int[][] mat) {
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int c1 = stack.pop();
            int c2 = stack.pop();
            if (mat[c1][c2] == 1 && mat[c2][c1] == 0) {
                stack.push(c2);
            } else if (mat[c2][c1] == 1 && mat[c1][c2] == 0) {
                stack.push(c1);
            }
        }

        while (!stack.isEmpty()) {
            int c = stack.pop();
            boolean flag = true;
            for (int i = 0; i < mat.length; i++) {
                if (i == c) {
                    continue;
                }
                if (mat[i][c] == 0 || mat[c][i] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return c;
            }
        }
        return -1;
    }
}
