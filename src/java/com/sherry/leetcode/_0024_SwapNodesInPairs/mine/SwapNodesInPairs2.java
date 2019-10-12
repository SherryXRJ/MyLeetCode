package com.sherry.leetcode._0024_SwapNodesInPairs.mine;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapNodesInPairs2 {

    /**
     * 换节点的指向
     * <p>
     * ① dummy(temp指向) -> 1 -> 2 -> 3
     * <p>
     * ② 1 -> 3;  2 -> 1 ;  dummy -> 2
     * <p>
     * ③ dummy(temp指向) -> 2 -> 1 -> 3
     * <p>
     * ④ 更改temp 指向 1 ,循环
     */
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode temp = result;
        while (temp.next != null && temp.next.next != null) {
            ListNode pre = temp.next;
            ListNode after = temp.next.next;

            temp.next = after;
            pre.next = after.next;
            after.next = pre;
            temp = pre;
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
