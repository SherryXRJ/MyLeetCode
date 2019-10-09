package com.sherry.leetcode._0019_RemoveNthNodeFromEndofList.optimization;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。<p/>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthNodeFromEndofList {

    /**
     * 双指针, 一次遍历
     * <p>
     * 指针A: 主要是用于定位，寻址
     * <p>
     * 指针B: 通过指针，找到并指向被删除节点的【前一个】节点
     *
     * 最后调整指针B: pointerB.next = pointerB.next.next
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pointerA = result;
        ListNode pointerB = result;
        //  指针A来寻址
        for (int i = 1; i <= n + 1; i++) {
            pointerA = pointerA.next;
        }

        //  指针A向后移动到null的步数，就是指针B向后移动到被删除节点【前一个节点】的步数
        while (pointerA != null) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        pointerB.next = pointerB.next.next;

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
