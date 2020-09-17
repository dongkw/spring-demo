package xyz.jecy.util.leetcode;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/5/25 2:44 下午
 */
public class Sum2 {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

  }


  private ListNode getVal(ListNode l1, ListNode l2, int f) {
    if (l1 == null && l2 == null && f == 0) {
      return null;
    }

    if (l1 == null) {
      l1 = new ListNode(0);
    }
    if (l2 == null) {
      l2 = new ListNode(0);
    }
    int s = l1.val + l2.val + f;
    int a = s / 10;
    int b = s % 10;

    ListNode listNode = new ListNode(b);

    listNode.next = getVal(l1.next, l2.next, a);

    return listNode;

  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    return getVal(l1, l2, 0);
  }

  public static void main(String[] args) {

    Sum2 sum2 = new Sum2();

    ListNode l1 = new ListNode(5);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
//    l1.next = l2;
//    l2.next = l3;

    ListNode r1 = new ListNode(5);
    ListNode r2 = new ListNode(6);
    ListNode r3 = new ListNode(4);
//    r1.next = r2;
//    r2.next = r3;
    ListNode re = sum2.addTwoNumbers(l1, r1);
    System.out.println(re.val);

  }
}
