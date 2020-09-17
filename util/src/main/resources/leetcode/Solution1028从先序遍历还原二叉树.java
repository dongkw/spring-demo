package xyz.jecy.util.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1028. 从先序遍历还原二叉树 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7" 输出：[1,2,5,3,4,6,7] 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7" 输出：[1,2,5,3,null,6,null,4,null,7] 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88" 输出：[1,401,null,349,88,90]
 */
public class Solution1028从先序遍历还原二叉树 {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode recoverFromPreorder(String s) {

    Deque<TreeNode> path = new LinkedList<>();
    int pos = 0;
    while (pos < s.length()) {
      int level = 0;
      while (s.charAt(pos) == '-') {
        ++level;
        ++pos;
      }
      int val = 0;
      while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
        val = val * 10 + s.charAt(pos) - '0';
        ++pos;
      }
      TreeNode node = new TreeNode(val);
      if (level == path.size()) {
        if (!path.isEmpty()) {
          path.peek().left = node;
        }
      } else {
        while (path.size() != level) {
          path.pop();
        }
        path.peek().right = node;
      }
      path.push(node);

    }
    while (path.size() > 1) {
      path.pop();
    }

    return path.peek();
  }

  public static void main(String[] args) {
    Solution1028从先序遍历还原二叉树 solution = new Solution1028从先序遍历还原二叉树();

    solution.recoverFromPreorder("1-2--3--4-5--6--7");

  }
}
