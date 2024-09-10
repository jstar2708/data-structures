package com.jaideep.dsalgo.linkedlist;

import com.jaideep.dsalgo.linkedlist.core.Node;

public class FlattenMultilevelDoublyLL {
    public Node flatten(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node child = curr.child;
                Node next = curr.next;
                curr.child = null;
                curr.next = flatten(child);
                child.prev = curr;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = next;
                if (next != null) {
                    next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
