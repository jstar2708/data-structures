package com.jaideep.dsalgo.linkedlist;

import com.jaideep.dsalgo.linkedlist.core.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode temp = head;
		int carry = 0;
		int value = 0;
		while (l1 != null && l2 != null) {
			value = l1.val + l2.val + carry;
			if (value < 9) {
				temp.next = new ListNode(value);
				carry = 0;
			} else {
				temp.next = new ListNode(value % 10);
				carry = value / 10;
			}
			l1 = l1.next;
			l2 = l2.next;
			temp = temp.next;
		}
		while (l1 != null) {
			value = l1.val + carry;
			if (value < 9) {
				temp.next = new ListNode(value);
				carry = 0;
			} else {
				temp.next = new ListNode(value % 10);
				carry = value / 10;
			}
			l1 = l1.next;
			temp = temp.next;
		}
		while (l2 != null) {
			value = l2.val + carry;
			if (value < 9) {
				temp.next = new ListNode(value);
				carry = 0;
			} else {
				temp.next = new ListNode(value % 10);
				carry = value / 10;
			}
			l2 = l2.next;
			temp = temp.next;
		}
		if (carry != 0) {
			temp.next = new ListNode(carry);
		}
		return head.next;
	}
}
