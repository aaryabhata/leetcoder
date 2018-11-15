package com.leetcode;


class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = null;
        int carry = 0;
        ListNode cur = null;
        while (l1 != null || l2 != null) {
            int sum = carry;
            sum += (l1 != null) ? l1.val : 0;
            sum += (l2 != null) ? l2.val : 0;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            if (ret == null) {
                ret = new ListNode(sum);
                cur = ret;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ret;
    }

    public static ListNode makeList(int[] a) {
        ListNode head = null, current = null;
        for (int anA : a) {
            if (head == null) {
                head = new ListNode(anA);
                head.next = null;
                current = head;

            } else {
                current.next = new ListNode(anA);
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode sumNode = addTwoNumbers.addTwoNumbers(makeList(new int[]{1, 2}), makeList(new int[]{3, 4}));
        for (ListNode curr = sumNode; curr != null; curr = curr.next) {
            System.out.print(curr.val);
        }
        System.out.println();
    }
}