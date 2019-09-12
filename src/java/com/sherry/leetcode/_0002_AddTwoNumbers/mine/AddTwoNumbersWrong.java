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
public class AddTwoNumbersWrong {

    /**
     * 需要注意int类型越界，因此不能先将两个链表的数字进行相加求和再进行分解<p/>
     * 这种方式就会出错
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = getNum(l1);
        int n2 = getNum(l2);
        return getNode(n1 + n2);
    }

    public int getNum(ListNode l){
        int num = l.val;
        int step = 10;
        while (l.next != null) {
            l = l.next;
            num += step * l.val;
            step *= 10;
        }
        return num;
    }

    public ListNode getNode(int num) {
        ListNode head = new ListNode(num % 10);
        num /= 10;
        ListNode temp = head;
        while (num > 0) {
            ListNode node = new ListNode(num % 10);
            temp.next = node;
            temp = node;
            num /= 10;
        }
        return head;
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
        AddTwoNumbersWrong addTwoNumbers = new AddTwoNumbersWrong();
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
