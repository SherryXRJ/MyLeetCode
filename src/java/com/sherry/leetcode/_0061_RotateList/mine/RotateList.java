package com.sherry.leetcode._0061_RotateList.mine;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        //  特殊值处理
        if (head == null) return null;
        if (head.next == null || k == 0) return head;

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

        //  k是size的整数倍 相当于链表没有移动 直接返回head
        if (k % size == 0) {
            return head;
        }

        //  把原来链表的接上
        oldTail.next = oldHead;


        //  k != size的整数倍规律
        int index = Math.abs(size - k % size);


        //  找到新的head与新的tail， 将新的tail.next -> null
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
        ListNode node = demo.rotateRight(n3, 2);
        System.out.println(node);
    }
}
