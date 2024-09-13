package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String exp = "3 + 5 * ( 2 - 8 / ( 3 + 1 ) ) * 2 + 4";
        final Stack<Character> operatorStack = new Stack<>();
        final Stack<String> numberStack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                numberStack.push(String.valueOf(ch));
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    String val2 = numberStack.pop();
                    String val1 = numberStack.pop();
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
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        String val2 = numberStack.pop();
                        String val1 = numberStack.pop();
                        char op = operatorStack.pop();
                        numberStack.push(applyOperation(val1, val2, op));
                    }
                    operatorStack.push(ch);
                } else if ((ch == '*' || ch == '/') && (operatorStack.peek() == '+' || operatorStack.peek() == '-')) {
                    operatorStack.push(ch);
                } else {
                    String val2 = numberStack.pop();
                    String val1 = numberStack.pop();
                    char op = operatorStack.pop();
                    numberStack.push(applyOperation(val1, val2, op));
                    operatorStack.push(ch);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            String val2 = numberStack.pop();
            String val1 = numberStack.pop();
            char op = operatorStack.pop();
            numberStack.push(applyOperation(val1, val2, op));
        }
        System.out.println(numberStack.pop());
    }

    private static String applyOperation(String val1, String val2, char op) {
        return op + val1 + val2;
    }
}
