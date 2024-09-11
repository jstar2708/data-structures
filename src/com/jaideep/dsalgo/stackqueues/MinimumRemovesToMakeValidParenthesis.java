package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class MinimumRemovesToMakeValidParenthesis {

	public String minRemoveToMakeValid(String s) {
		final Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			}
			else if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
				stack.pop();
			}
			else if (s.charAt(i) == ')'){
				stack.push(i);
			}
		}
		StringBuilder str = new StringBuilder(s);
		while (!stack.isEmpty()) {
			str.replace(stack.peek(), stack.pop()+1, "#");
		}
		return str.toString().replace("#", "");
	}
}
