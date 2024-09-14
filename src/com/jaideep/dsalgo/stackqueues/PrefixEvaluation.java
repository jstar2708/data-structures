package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class PrefixEvaluation {
    public static void main(String[] args) {
        String exp = "++3**5-2/8+3124";
        final Stack<Integer> stack = new Stack<>();
        for (int i = exp.length()-1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(applyOperation(val1, val2, ch));
            }
        }
        System.out.println(stack.pop());
    }

    private static int applyOperation(int val1, int val2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = val1 + val2;
                break;
            case '-':
                result = val1 - val2;
                break;
            case '*':
                result = val1 * val2;
                break;
            default:
                result = val1 / val2;
        }
        return result;
    }
}
