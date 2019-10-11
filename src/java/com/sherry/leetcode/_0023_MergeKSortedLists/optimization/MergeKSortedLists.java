package com.sherry.leetcode._0023_MergeKSortedLists.optimization;

/**
 * 23. 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKSortedLists {

    /**
     * 分治法、递归
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return this.mergeTwoLists(lists[0], lists[1]);

        int mid = lists.length / 2;
        //  前半段
        ListNode[] l1 = new ListNode[mid];

        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }

        //  后半段
        ListNode[] l2 = new ListNode[((lists.length & 1) == 0) ? mid : mid + 1];
        for (int i = mid, j = 0; i < lists.length; i++, j++) {
            l2[j] = lists[i];
        }

        //  递归合并
        ListNode node1 = this.mergeKLists(l1);
        ListNode node2 = this.mergeKLists(l2);

        return this.mergeTwoLists(node1, node2);
    }

    /**
     * 合并两个有序链表(21题)
     */
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


}
