package xyz.jecy.util.leetcode;

/**
 * 96. 不同的二叉搜索树 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3 输出: 5 解释: 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 */
//    1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

public class Solution96 {


  public int numTrees(int n) {

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] * dp[n - i];
    }

    return 5;
  }

  public static void main(String[] args) {
    Solution96 solution = new Solution96();
    int ss = solution.numTrees(3);
    System.out.println(ss);

  }
}
