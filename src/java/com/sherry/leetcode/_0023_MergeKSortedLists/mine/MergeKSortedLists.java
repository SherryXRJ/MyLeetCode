package com.sherry.leetcode._0023_MergeKSortedLists.mine;

import java.util.ArrayList;
import java.util.List;

/**
 * 23. 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKSortedLists {

    /**
     * 暴力法
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        List<Integer> nums = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                nums.add(node.val);
                node = node.next;
            }
        }

        ListNode temp = result;
        nums.sort((o1, o2) -> {
            if (o1.equals(o2)) return 0; else return o1 > o2 ? 1 : -1;
        });
        for (Integer n : nums) {
            temp.next = new ListNode(n);
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
