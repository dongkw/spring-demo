package xyz.jecy.util.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import xyz.jecy.util.leetcode.Solution19.ListNode;

/**
 * 21. 合并两个有序链表 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 */
public class Solution21 {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val <= l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }

  }


  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

    ListNode start = new ListNode(0);
    ListNode now = start;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        now.next = l2;
        l2 = l2.next;
      } else {
        now.next = l1;
        l1 = l1.next;
      }
      now = now.next;
    }
    if (l1 != null) {
      now.next = l1;
    }
    if (l2 != null) {
      now.next = l2;
    }

    return start.next;
  }

  public static void main(String[] args) {
    Solution21 solution = new Solution21();

    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    l1.next = l2;
    l2.next = l3;

    ListNode r1 = new ListNode(2);
    ListNode r2 = new ListNode(3);
    ListNode r3 = new ListNode(4);
    r1.next = r2;
    r2.next = r3;

    ListNode ss = solution.mergeTwoLists(l1, r1);
    System.out.println(ss);

  }
}
