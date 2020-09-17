package xyz.jecy.util.leetcode;

import xyz.jecy.util.leetcode.Sum2.ListNode;

/**
 * 19. 删除链表的倒数第N个节点 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode(0);
    start.next = head;
    ListNode now = start;
    ListNode nextn = getNext(now, n);
    while (nextn.next != null) {
      now = now.next;
      nextn = nextn.next;
    }
    now.next = now.next.next;
    return start.next;
  }


  private ListNode getNext(ListNode head, int n) {
    if (n > 0) {
      return getNext(head.next, n - 1);
    }
    return head;
  }


  public static void main(String[] args) {
    Solution19 solution = new Solution19();

    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;

    ListNode ss = solution.removeNthFromEnd(l1, 2);
    System.out.println(ss);

  }
}
