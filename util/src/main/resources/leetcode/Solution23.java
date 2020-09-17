package xyz.jecy.util.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 21. 合并两个有序链表 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 */
public class Solution23 {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    return helper(lists, 0, lists.length - 1);
  }


  private ListNode helper(ListNode[] lists, int begin, int end) {
    if (begin == end) {
      return lists[begin];
    }
    int mid = begin + (end - begin) / 2;
    ListNode left = helper(lists, begin, mid);
    ListNode right = helper(lists, mid + 1, end);
    return merge(left, right);
  }

  public ListNode mergeKList(ListNode[] listNodes) {
    if (listNodes == null || listNodes.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });

    for (int i = 0; i < listNodes.length; i++) {
      while (listNodes[i] != null) {
        queue.add(listNodes[i]);
        listNodes[i] = listNodes[i].next;
      }
    }
    ListNode start = new ListNode(-1);
    ListNode now = start;
    while (!queue.isEmpty()) {
      now.next = queue.poll();
      now = now.next;
    }
    return start.next;

  }


  public ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val > l2.val) {
      l2.next = merge(l1, l2.next);
      return l2;
    } else {
      l1.next = merge(l1.next, l2);
      return l1;
    }

  }

  public ListNode merge(ListNode[] listNodes, int len) {

    PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });

    for (int i = 0; i < listNodes.length; i++) {
      while (listNodes[i] != null) {
        queue.add(listNodes[i]);
        listNodes[i] = listNodes[i].next;
      }
    }
    ListNode start = new ListNode(-1);
    ListNode now = start;
    while (!queue.isEmpty()) {
      now.next = queue.poll();
      now = now.next;
    }

    return start.next;
  }


  public static void main(String[] args) {
    Solution23 solution = new Solution23();

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
    List<ListNode> listNodes = new ArrayList<>();
    listNodes.add(l1);
    listNodes.add(r1);
    ListNode ss = solution.mergeKLists(new ListNode[]{l1, r1});
    System.out.println(ss);

  }
}
