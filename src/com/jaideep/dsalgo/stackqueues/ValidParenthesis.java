package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class ValidParenthesis {
	public boolean isValid(String s) {
		final Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.charAt(i));
			}
			else if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			}
			else if (s.charAt(i) == ']' && stack.peek() == '['){
				stack.pop();
			}
			else if (s.charAt(i) == '}' && stack.peek() == '{') {
				stack.pop();
			}
			else if (s.charAt(i) == ')' && stack.peek() == '(') {
				stack.pop();
			}
			else {
				stack.push(s.charAt(i));
			}
		}
		return stack.isEmpty();
	}
}
