package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class InfixExpressionEvaluation {
    public static void main(String[] args) {
        String exp = "3 + 5 * ( 2 - 8 / ( 3 + 1 ) ) * 2 + 4";       // Answer is 7

        final Stack<Character> operatorStack = new Stack<>();
        final Stack<Integer> numberStack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                numberStack.push(ch - '0');
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    int val2 = numberStack.pop();
                    int val1 = numberStack.pop();
                    char op = operatorStack.pop();
                    numberStack.push(applyOperation(val1, val2, op));
                }
                operatorStack.pop();
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(ch);
                } else if (operatorStack.peek() == '(') {
                    operatorStack.push(ch);
                } else if ((ch == '+' || ch == '-')) {
                    int val2 = numberStack.pop();
                    int val1 = numberStack.pop();
                    char op = operatorStack.pop();
                    numberStack.push(applyOperation(val1, val2, op));
                    operatorStack.push(ch);
                } else if ((ch == '*' || ch == '/') && (operatorStack.peek() == '+' || operatorStack.peek() == '-')) {
                    operatorStack.push(ch);
                } else {
                    int val2 = numberStack.pop();
                    int val1 = numberStack.pop();
                    char op = operatorStack.pop();
                    numberStack.push(applyOperation(val1, val2, op));
                    operatorStack.push(ch);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            int val2 = numberStack.pop();
            int val1 = numberStack.pop();
            char op = operatorStack.pop();
            numberStack.push(applyOperation(val1, val2, op));
        }
        System.out.println(numberStack.pop());
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
