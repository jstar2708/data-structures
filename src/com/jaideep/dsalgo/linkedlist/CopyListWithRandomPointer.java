package com.jaideep.dsalgo.linkedlist;

import com.jaideep.dsalgo.linkedlist.core.Node;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node org = head;
        Node copy;
        Node next;
        while (org != null) {
            copy = new Node(org.val);
            next = org.next;
            org.next = copy;
            copy.next = next;
            org = org.next.next;
        }
        org = head;
        while (org != null && org.next != null) {
            if (org.random != null) {
                org.next.random = org.random.next;
            }
            org = org.next.next;
        }
        org = head;
        Node newHead = head.next;
        copy = newHead;
        while (copy != null && copy.next != null) {
            org.next = org.next.next;
            copy.next = copy.next.next;
            copy = copy.next;
            org = org.next;
        }
        org.next = null;
        return newHead;
    }
}
