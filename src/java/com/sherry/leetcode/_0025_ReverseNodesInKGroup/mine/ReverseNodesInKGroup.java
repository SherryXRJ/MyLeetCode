package com.sherry.leetcode._0025_ReverseNodesInKGroup.mine;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        result.next = head;
        this.reverseListNode(result, head, k);

        return result.next;
    }

    /**
     * 反转局部链表（4个特殊指针 pre after originHead  originTail）
     * <p/>
     * 例 输入[1 -> 2 -> 3 -> 4 -> 5]  3
     * <p/>
     * 原始0(dummy) -> 1 -> 2 -> 3 -> 4 -> 5
     * <p>
     * pre = 0 , after = 4 , originHead = 1 , originTail = 3
     * <p>
     * 1 -> 2 -> 3 是需要翻转的部分，是current节点指向上一节点,并保存当前节点(用于下一节点指向)
     * <p>
     * 最后调整特殊指针: pre.next = originTail; originHead.next = after; 再递归后续需要调整的链表
     *
     * @param pre  局部链表前一个节点
     * @param list 需要翻转的链表
     * @param size 翻转节点个数
     */
    private void reverseListNode(ListNode pre, ListNode list, int size) {
        ListNode checkNode = pre;

        //  原始头
        ListNode originHead = list;

        //  原始尾
        ListNode originTail = null;


        for (int i = 0; i < size; i++) {
            //  链表节点个数不够 直接返回
            checkNode = checkNode.next;
            if (checkNode == null) return;
            originTail = checkNode;
        }

        // 原始尾的下一个节点
        ListNode after = originTail == null ? null : originTail.next;

        ListNode current = list;
        ListNode temp = list;
        ListNode oriNext;
        //  翻转
        for (int i = 0; i < size; i++) {
            oriNext = current.next;
            current.next = temp;
            temp = current;
            current = oriNext;
        }

        pre.next = originTail;
        originHead.next = after;

        this.reverseListNode(originHead, originHead.next, size);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ReverseNodesInKGroup demo = new ReverseNodesInKGroup();
        ListNode result = demo.reverseKGroup(node, 3);
        System.out.println(result);
    }


}
