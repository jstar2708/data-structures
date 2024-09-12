package com.jaideep.dsalgo.stackqueues;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private final Stack<Integer> mStack;
    private final Stack<Integer> tempStack;

    public ImplementQueueUsingStacks() {
        mStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        mStack.push(x);
    }

    public int pop() {
        while (!mStack.isEmpty()) {
            tempStack.push(mStack.pop());
        }
        final int value = tempStack.pop();
        while (!tempStack.isEmpty()) {
            mStack.push(tempStack.pop());
        }
        return value;
    }

    public int peek() {
        while (!mStack.isEmpty()) {
            tempStack.push(mStack.pop());
        }
        final int value = tempStack.peek();
        while (!tempStack.isEmpty()) {
            mStack.push(tempStack.pop());
        }
        return value;
    }

    public boolean empty() {
        return mStack.isEmpty();
    }

}
