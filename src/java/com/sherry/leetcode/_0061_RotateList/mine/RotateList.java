package com.sherry.leetcode._0061_RotateList.mine;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode oldHead = head;
        ListNode oldTail = null;

        ListNode newHead = null;
        ListNode newTail = null;

        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.next == null) {
                oldTail = temp;
            }
            size++;
            temp = temp.next;
        }

        oldTail.next = oldHead;


        int index = Math.abs(size - k);

        temp = oldHead;
        for (int i = 0; i < size; i++) {
            if (index == i) {
                newHead = temp;
            }

            if (i == index - 1) {
                newTail = temp;
            }
            temp = temp.next;
        }

        newTail.next = null;
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        RotateList demo = new RotateList();
        ListNode node = demo.rotateRight(n1, 5);
        System.out.println(node);
    }
}
