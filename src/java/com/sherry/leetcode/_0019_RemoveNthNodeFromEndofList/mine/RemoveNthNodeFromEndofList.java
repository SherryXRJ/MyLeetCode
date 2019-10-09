package com.sherry.leetcode._0019_RemoveNthNodeFromEndofList.mine;

import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。<p/>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode result = new ListNode(0);
        temp = result;
        for (int i = 0; i < size && head != null; i++) {
            if (size == 1 && n == 1) return null;
            if (i != size - n) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        RemoveNthNodeFromEndofList demo = new RemoveNthNodeFromEndofList();
        ListNode listNode = demo.removeNthFromEnd(l1, 1);
        System.out.println(listNode);
    }
}
