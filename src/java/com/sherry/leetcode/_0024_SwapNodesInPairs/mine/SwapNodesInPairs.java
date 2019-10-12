package com.sherry.leetcode._0024_SwapNodesInPairs.mine;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapNodesInPairs {

    /**
     * 并不是交换节点，而是new了一个新节点
     */
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (head != null) {
            if (head.next == null) {
                temp.next = head;
                break;
            }
            temp.next = new ListNode(head.next.val);
            temp = temp.next;
            temp.next = new ListNode(head.val);
            temp = temp.next;

            head = head.next.next;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
