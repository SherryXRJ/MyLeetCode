package com.sherry.leetcode._0002_AddTwoNumbers.mine;

/**
 * 两数相加<p/>
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 <p/>
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    /**
     * 解：同时迭代两个链表，直接讲元素进行相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);  //  这个是多余的节点
        ListNode temp = result;
        int num = 0;
        while (l1 != null || l2 != null) {
            //  解决低位相加进位问题
            num /= 10;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }

            //  对10取余
            temp.next = new ListNode(num % 10);
            temp = temp.next;
        }

        //  最后一位相加进位
        if ((num /= 10) > 0) {
            temp.next = new ListNode(num);
        }

        //  去掉多余的节点
        return result.next;
    }


    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);

        ListNode node = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(node);
    }
}
