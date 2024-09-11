package com.jaideep.dsalgo.linkedlist;

import com.jaideep.dsalgo.linkedlist.core.ListNode;

public class SwappingNodesInLL {

	public static ListNode swapNodes(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		int size = getSize(head);
		int i = 1;
		ListNode t1 = head;
		ListNode t2 = null;

		int s = Math.min(size-k+1, k);
		int e = Math.max(size-k+1, k);
		while (i < k) {
			t1 = t1.next;
			i++;
		}
		t2 = t1;
		while (i < e) {
			t2 = t2.next;
			i++;
		}
		t1.val = t1.val + t2.val;
		t2.val = t1.val - t2.val;
		t1.val = t1.val - t2.val;
		return head;
	}

	private static int getSize(ListNode temp) {
		int size = 0;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}
}
