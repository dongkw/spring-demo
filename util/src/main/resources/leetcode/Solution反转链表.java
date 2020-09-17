package xyz.jecy.util.leetcode;

import java.util.Arrays;

/**
 * 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 */
public class Solution反转链表 {

    public static class ListNode {

      int val;
      ListNode next;

      ListNode(int x) {
        val = x;
      }
    }

  public ListNode reverseList(ListNode head) {
    ListNode now=null;
    ListNode temp=null;
    while(head!=null){
      temp=head.next;
      head.next=now;
      now=head;
      head=temp;

    }

    return temp;
  }
  public static void main(String[] args) {
//    Solution反转链表 solution = new Solution反转链表();
//
//    ListNode l1 = new ListNode(1);
//    ListNode l2 = new ListNode(2);
//    ListNode l3 = new ListNode(3);
//    ListNode l4 = new ListNode(4);
//    ListNode l5 = new ListNode(5);
//    l1.next = l2;
//    l2.next = l3;
//    l3.next = l4;
//    l4.next = l5;
//    solution.reverseList(l1);


    for(int i=0;i<10;i++){
      double d=Math.random()*3;
      int aa= (int) (d/1);

      System.out.println(aa);
    }
  }

}
