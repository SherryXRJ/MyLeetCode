package com.sherry.leetcode._0021_MergeTwoSortedLists.mine;

/**
 * 21. 合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pointerA = l1;
        ListNode pointerB = l2;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (pointerA != null || pointerB != null) {
            if (pointerA != null && pointerB != null) {
                boolean isLess = pointerA.val < pointerB.val;
                temp.next = new ListNode(isLess ? pointerA.val : pointerB.val);
                if (isLess) pointerA = pointerA.next; else pointerB = pointerB.next;
            } else if (pointerA != null && pointerB == null ) {
                temp.next = new ListNode(pointerA.val);
                pointerA = pointerA.next;
            } else if (pointerB != null && pointerA == null) {
                temp.next = new ListNode(pointerB.val);
                pointerB = pointerB.next;
            }
            temp = temp.next;
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

    public static void main(String[] args) {
        ListNode l1 = null;

        ListNode l2 = new ListNode(0);


        MergeTwoSortedLists demo = new MergeTwoSortedLists();
        ListNode listNode = demo.mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }
}
