package com.jpfeng.leetcode;

/**
 * 两数相加
 * <p>
 * 给出两个 *非空* 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 *逆序* 的方式存储的，并且它们的每个节点只能存储 *一位* 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Jpfeng
 * e-mail: fengjup@live.com
 * date: 2018/12/28
 */
public class LeetCode0002 {

    /**
     * node1, node2, 进位
     * time: 65ms
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        int shift = 0;
        ListNode result = new ListNode(shift);
        ListNode current = result;

        while (null != n1 || null != n2) {
            int val1 = null == n1 ? 0 : n1.val;
            int val2 = null == n2 ? 0 : n2.val;
            int val = val1 + val2 + current.val;
            current.val = val % 10;
            if (null != n1) {
                n1 = n1.next;
            }
            if (null != n2) {
                n2 = n2.next;
            }
            if (null != n1 || null != n2 || val / 10 > 0) {
                current.next = new ListNode(val / 10);
                current = current.next;
            }
        }

        return result;
    }

    /**
     * time: 57ms
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        int shift = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (null != n1 || null != n2) {
            int val1 = null == n1 ? 0 : n1.val;
            int val2 = null == n2 ? 0 : n2.val;
            int val = val1 + val2 + shift;
            shift = val / 10;
            current.next = new ListNode(val % 10);
            current = current.next;
            n1 = null == n1 ? null : n1.next;
            n2 = null == n2 ? null : n2.next;
        }

        if (shift > 0) {
            current.next = new ListNode(shift);
        }

        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
