package com.tml.mouseDemo.core.algorithm.leetcode;

/**
 * 链表翻转
 */
public class ReverseLinkedList {

    public static void main(String[] args) {


        int[] nodes = new int[]{1, 2, 43, 6, 7};
        ListNode first = new ListNode();
        first.setVal(nodes[0]);

        ListNode tmp = first;

        for (int i = 1; i < nodes.length; i++) {
            ListNode current = new ListNode();
            current.setVal(nodes[i]);
            tmp.setNext(current);

            tmp = current;
        }



        System.out.println(tmp);

        ListNode listNode = reverseList(first);

        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.getNext();
            cur.next = pre;

            pre = cur;
            cur = next;
        }


        return pre;

    }
}


 class ListNode {
    public int val;
    public ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}